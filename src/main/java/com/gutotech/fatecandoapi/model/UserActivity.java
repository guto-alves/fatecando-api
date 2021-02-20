package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UserActivity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@OneToOne
	@MapsId
	private User user;

	@Column(name = "right_answers")
	private int rightAnswers;

	@Column(name = "wrong_answers")
	private int wrongAnswers;

	@Column(name = "game_wins")
	private int gameWins;

	@Column(name = "game_losses")
	private int gameLosses;

	@Column(name = "complete_tests")
	private int completeTests;

	@Column(name = "content_uploaded")
	private int contentUploaded;

	public UserActivity() {
	}

	public UserActivity(User user) {
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getRightAnswers() {
		return rightAnswers;
	}

	public void setRightAnswers(int rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	public int getWrongAnswers() {
		return wrongAnswers;
	}

	public void setWrongAnswers(int wrongAnswers) {
		this.wrongAnswers = wrongAnswers;
	}

	public int getGameWins() {
		return gameWins;
	}

	public void setGameWins(int gameWins) {
		this.gameWins = gameWins;
	}

	public int getGameLosses() {
		return gameLosses;
	}

	public void setGameLosses(int gameLosses) {
		this.gameLosses = gameLosses;
	}

	public int getCompleteTests() {
		return completeTests;
	}

	public void setCompleteTests(int completeTests) {
		this.completeTests = completeTests;
	}

	@Override
	public int hashCode() {
		return Objects.hash(user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserActivity)) {
			return false;
		}
		UserActivity other = (UserActivity) obj;
		return Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "StudentActivity [user=" + user.getFirstName() + ", rightAnswers=" + rightAnswers + ", wrongAnswers="
				+ wrongAnswers + ", gameWins=" + gameWins + ", gameLosses=" + gameLosses + ", completeTests="
				+ completeTests + ", contentUploaded=" + contentUploaded + "]";
	}

}
