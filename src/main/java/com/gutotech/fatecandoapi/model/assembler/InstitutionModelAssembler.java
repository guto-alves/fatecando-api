package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Institution;
import com.gutotech.fatecandoapi.rest.InstitutionRestController;

@Component
public class InstitutionModelAssembler implements RepresentationModelAssembler<Institution, EntityModel<Institution>> {

	@Override
	public EntityModel<Institution> toModel(Institution institution) {
		return EntityModel.of(institution, //
				linkTo(methodOn(InstitutionRestController.class).getInstitution(institution.getId())).withSelfRel(),
				linkTo(methodOn(InstitutionRestController.class).getAllInstitutions()).withRel("institutions"));
	}

}
