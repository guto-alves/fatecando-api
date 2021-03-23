package com.gutotech.fatecandoapi.model;

import javax.persistence.Embeddable;

@Embeddable
public class Feedback {
	private Long alternative;
	private boolean correct;
	private String text;

	public Feedback() {
	}

	public Feedback(Long alternative, boolean correct, String text) {
		this.alternative = alternative;
		this.correct = correct;
		this.text = text;
	}

	public Long getAlternative() {
		return alternative;
	}

	public void setAlternative(Long alternative) {
		this.alternative = alternative;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
