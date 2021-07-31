package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "reward_users")
public class RewardUser {

	@Id
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@JsonIgnore
	@ManyToOne
	private Reward reward;

	@JsonIgnore
	@ManyToOne
	private User user;

	public RewardUser() {
	}

	public RewardUser(Date date, Reward reward, User user) {
		this.date = date;
		this.reward = reward;
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Reward getReward() {
		return reward;
	}

	public void setReward(Reward reward) {
		this.reward = reward;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof RewardUser)) {
			return false;
		}
		RewardUser other = (RewardUser) obj;
		return Objects.equals(date, other.date);
	}

}
