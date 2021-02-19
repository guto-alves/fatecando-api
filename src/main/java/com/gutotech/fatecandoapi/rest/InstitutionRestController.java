package com.gutotech.fatecandoapi.rest;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gutotech.fatecandoapi.model.Institution;
import com.gutotech.fatecandoapi.model.assembler.InstitutionModelAssembler;
import com.gutotech.fatecandoapi.service.InstitutionService;

@RestController
@RequestMapping("institutions")
public class InstitutionRestController {

	@Autowired
	private InstitutionService service;

	@Autowired
	private InstitutionModelAssembler assembler;

	@GetMapping
	public CollectionModel<EntityModel<Institution>> getAllInstitutions() {
		List<EntityModel<Institution>> courses = service.findAll().stream() //
				.map(assembler::toModel) //
				.collect(Collectors.toList());

		return CollectionModel.of(courses, //
				linkTo(methodOn(InstitutionRestController.class).getAllInstitutions()).withSelfRel());
	}

	@GetMapping("{id}")
	public EntityModel<Institution> getInstitution(@PathVariable Long id) {
		Institution institution = service.findById(id);

		return assembler.toModel(institution);
	}

	@PostMapping
	public ResponseEntity<?> addInstitution(@RequestBody @Valid Institution institution, BindingResult bindingResult) {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();

		if (bindingResult.hasErrors() || institution == null) {
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return ResponseEntity.badRequest().headers(headers).build();
		}

		EntityModel<Institution> entityModel = assembler.toModel(service.save(institution));

		return ResponseEntity.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateInstitution(@RequestBody @Valid Institution newInstitution, //
			@PathVariable Long id, BindingResult bindingResult) {
		BindingErrorsResponse errors = new BindingErrorsResponse();
		HttpHeaders headers = new HttpHeaders();

		if (bindingResult.hasErrors() || newInstitution == null) {
			errors.addAllErrors(bindingResult);
			headers.add("errors", errors.toJSON());
			return ResponseEntity.badRequest().headers(headers).build();
		}

		Institution institution = service.findById(id);
		institution.setName(newInstitution.getName());

		EntityModel<Institution> entityModel = assembler.toModel(institution);

		return ResponseEntity //
				.created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
				.body(entityModel);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteInstitution(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
