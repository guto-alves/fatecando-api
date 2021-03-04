package com.gutotech.fatecandoapi.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TopicUserId implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	private User user;

	@ManyToOne
	private Topic topic;

	public TopicUserId() {
	}

	public TopicUserId(User user, Topic topic) {
		this.user = user;
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	@Override
	public int hashCode() {
		return Objects.hash(topic, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TopicUserId)) {
			return false;
		}
		TopicUserId other = (TopicUserId) obj;
		return Objects.equals(topic, other.topic) && Objects.equals(user, other.user);
	}

}
