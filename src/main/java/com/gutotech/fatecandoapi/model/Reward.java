package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
	private Date date;

	@NotNull
	@Enumerated(EnumType.STRING)
	private RewardType rewardType;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public Reward() {
	}

	public Reward(RewardType rewardType, User user) {
		this.rewardType = rewardType;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getScore() {
		return rewardType.getScore();
	}

	public int getCoins() {
		return rewardType.getCoins();
	}

	public RewardType getRewardType() {
		return rewardType;
	}

	public void setRewardType(RewardType rewardType) {
		this.rewardType = rewardType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
		if (!(obj instanceof Reward)) {
			return false;
		}
		Reward other = (Reward) obj;
		return Objects.equals(id, other.id);
	}

}
