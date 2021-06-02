package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Ticket;
import com.gutotech.fatecandoapi.rest.SupportRestController;

@Component
public class TicketModelAssembler implements RepresentationModelAssembler<Ticket, EntityModel<Ticket>> {

	@Override
	public EntityModel<Ticket> toModel(Ticket ticket) {
		return EntityModel.of(ticket, //
				linkTo(methodOn(SupportRestController.class).getTicket(ticket.getId())).withSelfRel(),
				linkTo(methodOn(SupportRestController.class).getTickets()).withRel("tickets"));
	}

}
