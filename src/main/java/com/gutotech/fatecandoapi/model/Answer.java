package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "answers")
public class Answer {

	@EmbeddedId
	private AnswerId id = new AnswerId();

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date date;

	private boolean correct;

	public Answer() {
	}

	public Answer(User user, Question question, boolean correct) {
		id.setUser(user);
		id.setQuestion(question);
		this.correct = correct;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
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
		if (!(obj instanceof Answer)) {
			return false;
		}
		Answer other = (Answer) obj;
		return Objects.equals(id, other.id);
	}

}
