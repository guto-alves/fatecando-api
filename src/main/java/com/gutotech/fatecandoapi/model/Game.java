package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "games")
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Provide a name")
	@Size(max = 30)
	@Column(length = 30)
	private String name;

	@Size(min = 2, max = 10, message = "Choose at least two topics")
	@ManyToMany
	private List<Topic> topics = new ArrayList<>();

	@DecimalMin(value = "30", message = "The time to answer must be between 30 seconds and 5 minutes")
	@DecimalMax(value = "300", message = "The time to answer must be between 30 seconds and 5 minutes")
	@Column(name = "answer_time")
	private long answerTime;

	@Enumerated(EnumType.STRING)
	private GameStatus status;

	@DecimalMin(value = "2", message = "Total Players must be between 2 and 4")
	@DecimalMax(value = "4", message = "Total Players must be between 2 and 4")
	@Column(name = "total_players")
	private int totalPlayers;

	@ManyToMany
	private List<User> players = new ArrayList<>();

	@DecimalMin(value = "3", message = "Total Rounds must be between 3 and 6")
	@DecimalMax(value = "6", message = "Total Rounds must be between 3 and 6")
	@Column(name = "total_rounds")
	private int totalRounds;

	@Column(name = "current_round")
	private int currentRound;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Round> rounds = new ArrayList<>();

	@ManyToOne
	private User createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	public Game() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name != null ? name.trim() : null;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public long getAnswerTime() {
		return answerTime;
	}

	public void setAnswerTime(long answerTime) {
		this.answerTime = answerTime;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public int getTotalPlayers() {
		return totalPlayers;
	}

	public void setTotalPlayers(int totalPlayers) {
		this.totalPlayers = totalPlayers;
	}

	public List<User> getPlayers() {
		return players;
	}

	public void setPlayers(List<User> players) {
		this.players = players;
	}

	public int getTotalRounds() {
		return totalRounds;
	}

	public void setTotalRounds(int totalRounds) {
		this.totalRounds = totalRounds;
	}

	public int getCurrentRound() {
		return currentRound;
	}

	public void setCurrentRound(int currentRound) {
		this.currentRound = currentRound;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		if (!(obj instanceof Game)) {
			return false;
		}
		Game other = (Game) obj;
		return Objects.equals(id, other.id);
	}

}
