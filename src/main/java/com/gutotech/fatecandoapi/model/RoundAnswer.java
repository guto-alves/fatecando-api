package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "round_answer")
public class RoundAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User user;

	@Embedded
	private Feedback feedback = new Feedback();

	public RoundAnswer() {
	}

	public RoundAnswer(User user, Alternative alternative) {
		this.user = user;
		this.feedback.setAlternative(alternative.getId());
		this.feedback.setCorrect(alternative.isCorrect());
		this.feedback.setText(alternative.getFeedback());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
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
		if (!(obj instanceof RoundAnswer)) {
			return false;
		}
		RoundAnswer other = (RoundAnswer) obj;
		return Objects.equals(id, other.id);
	}

}
