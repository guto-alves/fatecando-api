package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class GameUserStatusId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Game game;

	@ManyToOne
	private User user;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(game, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof GameUserStatusId)) {
			return false;
		}
		GameUserStatusId other = (GameUserStatusId) obj;
		return Objects.equals(game, other.game) && Objects.equals(user, other.user);
	}

}
