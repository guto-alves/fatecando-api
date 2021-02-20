package com.gutotech.fatecandoapi.model;

public enum RewardType {
	GAME(60, 1000), TEST(30, 500), QUESTION(5, 250);

	private final int score;
	private final int coins;

	private RewardType(int score, int coins) {
		this.score = score;
		this.coins = coins;
	}

	public int getScore() {
		return score;
	}

	public int getCoins() {
		return coins;
	}

}
