package com.gutotech.fatecandoapi.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "rounds")
public class Round {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@ManyToOne
	private Question question;

	@JsonIgnore
	@NotNull
	@ManyToOne
	private Game game;

	private long startTime;

	@ManyToMany
	private Set<User> usersWhoAnswered = new HashSet<>();

	public Round() {
	}

	public Round(Question question, Game game, long startTime) {
		this.question = question;
		this.game = game;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@JsonIgnore
	public Set<User> getUsersWhoAnswered() {
		return usersWhoAnswered;
	}

	public void setUsersWhoAnswered(Set<User> usersWhoAnswered) {
		this.usersWhoAnswered = usersWhoAnswered;
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
