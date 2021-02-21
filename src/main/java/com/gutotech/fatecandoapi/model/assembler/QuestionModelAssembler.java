package com.gutotech.fatecandoapi.model.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.rest.QuestionRestController;

@Component
public class QuestionModelAssembler implements RepresentationModelAssembler<Question, EntityModel<Question>> {

	@Override
	public EntityModel<Question> toModel(Question question) {
		return EntityModel.of(question,
				linkTo(methodOn(QuestionRestController.class).getQuestion(question.getId())).withSelfRel());
	}

}
