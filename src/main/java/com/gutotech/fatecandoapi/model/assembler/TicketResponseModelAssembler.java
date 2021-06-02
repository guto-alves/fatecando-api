package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.TicketResponse;
import com.gutotech.fatecandoapi.rest.SupportRestController;

@Component
public class TicketResponseModelAssembler
		implements RepresentationModelAssembler<TicketResponse, EntityModel<TicketResponse>> {

	@Override
	public EntityModel<TicketResponse> toModel(TicketResponse response) {
		return EntityModel.of(response, //
				linkTo(methodOn(SupportRestController.class).getTickets()).withRel("tickets"));
	}

}
