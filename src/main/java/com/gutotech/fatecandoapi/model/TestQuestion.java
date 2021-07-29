package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "test_questions")
public class TestQuestion {

	@EmbeddedId
	private TestQuestionId id = new TestQuestionId();

	@ManyToOne
	@JoinColumn(name = "chosen_alternative")
	private Alternative chosenAlternative;

	public TestQuestion() {
	}

	public TestQuestion(Test test, Question question) {
		id.setTest(test);
		id.setQuestion(question);
	}

	@JsonIgnore
	public Test getTest() {
		return id.getTest();
	}

	public void setTest(Test test) {
		id.setTest(test);
	}

	public Question getQuestion() {
		return id.getQuestion();
	}

	public void setQuestion(Question question) {
		id.setQuestion(question);
	}

	public Alternative getChosenAlternative() {
		return chosenAlternative;
	}

	public void setChosenAlternative(Alternative chosenAlternative) {
		this.chosenAlternative = chosenAlternative;
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
		if (!(obj instanceof TestQuestion)) {
			return false;
		}
		TestQuestion other = (TestQuestion) obj;
		return Objects.equals(id, other.id);
	}

}
