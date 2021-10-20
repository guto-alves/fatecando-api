package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "question_types")
public class QuestionType {

	public static final QuestionType QUIZ = new QuestionType("QUIZ");
	public static final QuestionType TEST = new QuestionType("TEST");
	public static final QuestionType GAME = new QuestionType("GAME");

	@Id
	private String name;

	public QuestionType() {
	}

	public QuestionType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof QuestionType)) {
			return false;
		}
		QuestionType other = (QuestionType) obj;
		return Objects.equals(name, other.name);
	}

}
