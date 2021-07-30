package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class AlternativeDTO {
	private Long id;

	@NotBlank
	private String description;

	private Feedback feedback = new Feedback();

	@JsonIgnore
	private Question question;

	public AlternativeDTO() {
	}
	
	public AlternativeDTO(Alternative alternative) {
		this.id = alternative.getId();
		this.description = alternative.getDescription();
		this.feedback = alternative.getFeedback();
		this.feedback.setAlternative(alternative);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof AlternativeDTO)) {
			return false;
		}
		AlternativeDTO other = (AlternativeDTO) obj;
		return Objects.equals(id, other.id);
	}

}
