package com.gutotech.fatecandoapi.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide a name")
	@Column(length = 80)
	private String name;

	@Column(name = "total_users")
	@Size(min = 2, max = 4, message = "Total Users must be between 2 and 4")
	private int totalUsers;

	@Column(name = "time_to_answer")
	private long timeToAnswer;

	@Size(min = 3, max = 6, message = "Total Rounds must be between 3 and 6")
	@Column(name = "total_rounds")
	private int totalRounds;

	@Column(name = "current_round")
	private int currentRound;

	@Enumerated(EnumType.STRING)
	private GameStatus status;

	@CreationTimestamp
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date date;

	@ManyToOne
	private User user;

	@Size(min = 2, max = 10)
	@ManyToMany
	private List<Topic> topics = new ArrayList<>();

	@OneToMany(mappedBy = "id.game")
	private List<GameUserStatus> inGameUserStatus = new ArrayList<>();

	@OneToMany
	private List<Round> rounds = new ArrayList<>();

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
		this.name = name;
	}

	public int getTotalUsers() {
		return totalUsers;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	public long getTimeToAnswer() {
		return timeToAnswer;
	}

	public void setTimeToAnswer(long timeToAnswer) {
		this.timeToAnswer = timeToAnswer;
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

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Round> getRounds() {
		return rounds;
	}

	public void setRounds(List<Round> rounds) {
		this.rounds = rounds;
	}

	public List<GameUserStatus> getInGameUserStatus() {
		return inGameUserStatus;
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
