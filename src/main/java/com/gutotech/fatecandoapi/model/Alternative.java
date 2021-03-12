package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Alternative {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String description;

	private boolean correct;

	private String feedback;

	@JsonIgnore
	@ManyToOne
	private Question question;

	public Alternative() {
	}

	public Alternative(String description, String feedback, boolean correct) {
		this.description = description;
		this.feedback = feedback;
		this.correct = correct;
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

	@JsonIgnore
	public boolean isCorrect() {
		return correct;
	}

	@JsonProperty
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@JsonIgnore
	public String getFeedback() {
		return feedback;
	}

	@JsonProperty
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}

	@JsonIgnore
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
		if (!(obj instanceof Alternative)) {
			return false;
		}
		Alternative other = (Alternative) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Alternative [id=" + id + ", description=" + description + "]";
	}

}
