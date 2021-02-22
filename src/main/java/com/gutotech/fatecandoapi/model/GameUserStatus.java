package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class GameUserStatus {

	@EmbeddedId
	private GameUserStatusId id = new GameUserStatusId();

	private int hits;

	private boolean playing;

	public GameUserStatus() {
	}

	public GameUserStatus(Game game, User user, boolean playing) {
		id.setGame(game);
		id.setUser(user);
		this.playing = playing;
	}

	public GameUserStatus(Game game, User user, int hits, boolean playing) {
		id.setGame(game);
		id.setUser(user);
		this.hits = hits;
		this.playing = playing;
	}

	@JsonIgnore
	public Game getId() {
		return id.getGame();
	}

	public void setGame(Game game) {
		this.id.setGame(game);
	}

	public User getUser() {
		return id.getUser();
	}

	public void setUser(User user) {
		this.id.setUser(user);
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public boolean isPlaying() {
		return playing;
	}

	public void setPlaying(boolean playing) {
		this.playing = playing;
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
		if (!(obj instanceof GameUserStatus)) {
			return false;
		}
		GameUserStatus other = (GameUserStatus) obj;
		return Objects.equals(id, other.id);
	}

}
