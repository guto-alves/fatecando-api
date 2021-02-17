package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 2500)
	private String description;

	private int score;

	private int coins;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private List<Alternative> alternatives = new ArrayList<>();

	@JsonIgnore
	@ManyToOne
	private Test test;

	public Question() {
	}

	public Question(String description, int score, int coins, List<Alternative> alternatives) {
		this.description = description;
		this.score = score;
		this.coins = coins;

		alternatives.forEach((alternative) -> {
			alternative.setQuestion(this);
		});

		this.alternatives = alternatives;
	}

	public Question(String description, int score, int coins, List<Alternative> alternatives, Test test) {
		this.description = description;
		this.score = score;
		this.coins = coins;
		this.alternatives = alternatives;
		this.test = test;
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getCoins() {
		return coins;
	}

	public void setCoins(int coins) {
		this.coins = coins;
	}

	public List<Alternative> getAlternatives() {
		return alternatives;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
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
		if (!(obj instanceof Question)) {
			return false;
		}
		Question other = (Question) obj;
		return Objects.equals(id, other.id);
	}

}
