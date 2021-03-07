package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class DisciplineUser {

	@EmbeddedId
	private DisciplineUserId id = new DisciplineUserId();

	private Date accessDate;

	private boolean liked;

	public DisciplineUser() {
	}

	public DisciplineUser(Discipline discipline, User user) {
		id.setDiscipline(discipline);
		id.setUser(user);
	}

	public DisciplineUser(DisciplineUserId id, Date accessDate, boolean liked) {
		this.id = id;
		this.accessDate = accessDate;
		this.liked = liked;
	}

	@JsonIgnore
	public Discipline getDiscipline() {
		return id.getDiscipline();
	}

	public void setDiscipline(Discipline discipline) {
		id.setDiscipline(discipline);
	}

	@JsonIgnore
	public User getUser() {
		return id.getUser();
	}

	public void setUser(User user) {
		id.setUser(user);
	}

	public Date getAccessDate() {
		return accessDate;
	}

	public void setAccessDate(Date accessDate) {
		this.accessDate = accessDate;
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
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
		if (!(obj instanceof DisciplineUser)) {
			return false;
		}
		DisciplineUser other = (DisciplineUser) obj;
		return Objects.equals(id, other.id);
	}

}
