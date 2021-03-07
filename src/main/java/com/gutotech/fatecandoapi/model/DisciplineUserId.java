package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DisciplineUserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(optional = true)
	private Discipline discipline;

	@ManyToOne(optional = true)
	private User user;

	public DisciplineUserId() {
	}

	public DisciplineUserId(Discipline discipline, User user) {
		this.discipline = discipline;
		this.user = user;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(discipline, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof DisciplineUserId)) {
			return false;
		}
		DisciplineUserId other = (DisciplineUserId) obj;
		return Objects.equals(discipline, other.discipline) && Objects.equals(user, other.user);
	}

}
