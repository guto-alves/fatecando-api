package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "topic_users")
public class TopicUser {

	@EmbeddedId
	private TopicUserId id = new TopicUserId();

	private boolean liked;

	@Column(nullable = true)
	private boolean favorite;

	@Column(columnDefinition = "TEXT")
	private String annotation = "";

	private boolean finished;

	@Column(name = "finish_date")
	private Date finishDate;

	@Embedded
	private Review review;

	public TopicUser() {
	}

	public TopicUser(User user, Topic topic) {
		this(new TopicUserId(user, topic), false, "", false, null);
	}

	public TopicUser(TopicUserId id, boolean liked, String annotation, boolean finished, Date finishDate) {
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

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
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

	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
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
		if (!(obj instanceof TopicUser)) {
			return false;
		}
		TopicUser other = (TopicUser) obj;
		return Objects.equals(id, other.id);
	}

}
