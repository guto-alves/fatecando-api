package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "subject_users")
public class SubjectUser {

	@EmbeddedId
	private SubjectUserId id = new SubjectUserId();

	private Date accessDate;

	private boolean liked;

	public SubjectUser() {
	}

	public SubjectUser(Subject subject, User user) {
		id.setSubject(subject);
		id.setUser(user);
	}

	public SubjectUser(SubjectUserId id, Date accessDate, boolean liked) {
		this.id = id;
		this.accessDate = accessDate;
		this.liked = liked;
	}

	@JsonIgnore
	public Subject getDiscipline() {
		return id.getSubject();
	}

	public void setDiscipline(Subject subject) {
		id.setSubject(subject);
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

	public int getProgress() {
		Set<Topic> topics = id.getSubject().getTopics();

		long totalFinished = topics.stream().filter(topic -> topic.getUser().isFinished()).count();

		return totalFinished > 0 ? (int) ((double) totalFinished / topics.size() * 100) : 0;
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
		if (!(obj instanceof SubjectUser)) {
			return false;
		}
		SubjectUser other = (SubjectUser) obj;
		return Objects.equals(id, other.id);
	}

}
