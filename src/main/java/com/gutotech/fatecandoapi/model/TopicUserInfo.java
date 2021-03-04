package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class TopicUserInfo {

	@EmbeddedId
	private TopicUserId id = new TopicUserId();

	private boolean liked;

	@Column(length = 500)
	private String annotation = "";

	private boolean finished;

	@Column(name = "finish_date")
	private Date finishDate;

	public TopicUserInfo() {
	}

	public TopicUserInfo(User user, Topic topic) {
		this(new TopicUserId(user, topic), false, "", false, null);
	}

	public TopicUserInfo(TopicUserId id, boolean liked, String annotation, boolean finished, Date finishDate) {
		this.id = id;
		this.liked = liked;
		this.annotation = annotation;
		this.finished = finished;
		this.finishDate = finishDate;
	}

	@JsonIgnore
	public User getUser() {
		return id.getUser();
	}

	public void setUser(User user) {
		id.setUser(user);
	}

	@JsonIgnore
	public Topic getTopic() {
		return id.getTopic();
	}

	public void setTopic(Topic topic) {
		id.setTopic(topic);
	}

	public boolean isLiked() {
		return liked;
	}

	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
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
		if (!(obj instanceof TopicUserInfo)) {
			return false;
		}
		TopicUserInfo other = (TopicUserInfo) obj;
		return Objects.equals(id, other.id);
	}

}
