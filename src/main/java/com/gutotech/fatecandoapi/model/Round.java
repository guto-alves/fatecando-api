package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "rounds")
public class Round {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private Question question;

	private long startTime;

	@Transient
	private long secondsLeft;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RoundAnswer> answers = new ArrayList<>();

	public Round() {
	}

	public Round(Question question, long startTime) {
		this.question = question;
		this.startTime = startTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getSecondsLeft() {
		return secondsLeft;
	}

	public void setSecondsLeft(long secondsLeft) {
		this.secondsLeft = secondsLeft;
	}

	public List<RoundAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<RoundAnswer> answers) {
		this.answers = answers;
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
		if (!(obj instanceof Round)) {
			return false;
		}
		Round other = (Round) obj;
		return Objects.equals(id, other.id);
	}

}
