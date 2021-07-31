package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

public class RewardDTO {
	private RewardType type;
	private int score;
	private int coins;
	private Date date;

	public RewardDTO() {
	}

	public RewardDTO(RewardUser rewardUser) {
		this.type = rewardUser.getReward().getType();
		this.score = rewardUser.getReward().getScore();
		this.coins = rewardUser.getReward().getCoins();
		this.date = rewardUser.getDate();
	}

	public RewardType getType() {
		return type;
	}

	public void setType(RewardType type) {
		this.type = type;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
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
		if (!(obj instanceof RewardDTO)) {
			return false;
		}
		RewardDTO other = (RewardDTO) obj;
		return Objects.equals(date, other.date);
	}

}
