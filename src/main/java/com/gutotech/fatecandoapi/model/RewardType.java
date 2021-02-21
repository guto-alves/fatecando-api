package com.gutotech.fatecandoapi.model;

public enum RewardType {
	RIGHT_ANSWER(5, 100), WRONG_ANSWER(-15, 0), TEST_SUCCESS(30, 500), TEST_FAILURE(-30, 0), GAME(60, 1000);

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
