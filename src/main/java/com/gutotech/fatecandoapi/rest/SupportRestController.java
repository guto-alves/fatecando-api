package com.gutotech.fatecandoapi.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Ticket;
import com.gutotech.fatecandoapi.model.Ticket.Status;
import com.gutotech.fatecandoapi.model.TicketResponse;
import com.gutotech.fatecandoapi.model.assembler.TicketModelAssembler;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.TicketService;
import com.gutotech.fatecandoapi.service.UserService;

@RestController
@RequestMapping("api/tickets")
public class SupportRestController {

	@Autowired
	private TicketService ticketService;

	@Autowired
	private TicketModelAssembler assembler;

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<Ticket>> getTickets() {
		return ResponseEntity
				.ok(ticketService.findByUser(SecurityContextHolder.getContext().getAuthentication().getName()));
	}

	@GetMapping("{id}")
	public ResponseEntity<Ticket> getTicket(@PathVariable Long id) {
		Ticket ticket = ticketService.findById(id);

		if (!hasPermission(ticket.getUser().getEmail())) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(ticket);
	}

	@PostMapping
	public ResponseEntity<EntityModel<Ticket>> addTicket(@RequestBody @Valid Ticket ticket,
			BindingResult bindingResult) {
		ticket.setUser(userService.findCurrentUser());
		ticket.setStatus(Status.WAITING);
		EntityModel<Ticket> entityModel = assembler.toModel(ticketService.save(ticket));
		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@GetMapping("{id}/responses")
	public ResponseEntity<List<TicketResponse>> getTicketResponses(@PathVariable Long id) {
		Ticket ticket = ticketService.findById(id);

		if (!hasPermission(ticket.getUser().getEmail())) {
			return ResponseEntity.badRequest().build();
		}

		return ResponseEntity.ok(ticket.getResponses());
	}

	@PostMapping("{id}/responses")
	public ResponseEntity<TicketResponse> addTicketResponse(@PathVariable Long id,
			@RequestBody @Valid TicketResponse response) {
		Ticket ticket = ticketService.findById(id);

		if (ticket.getStatus() == Status.CLOSED || !hasPermission(ticket.getUser().getEmail())) {
			throw new IllegalStateException("Este Ticket já foi fechado ou você não tem permissão para responde-lo.");
		}

		response.setId(null);
		response.setUser(userService.findCurrentUser());
		ticket.getResponses().add(response);
		response.setTicket(ticket);

		EntityModel<Ticket> entityModel = assembler.toModel(ticketService.save(ticket));

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(response);
	}

	private boolean hasPermission(String onwerEmail) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		return auth != null && (auth.getName().equals(onwerEmail)
				|| auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(Roles.ADMIN)));
	}
}
