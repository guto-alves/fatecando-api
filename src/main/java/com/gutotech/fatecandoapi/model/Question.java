package com.gutotech.fatecandoapi.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "questions")
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String description;

	@NotNull
	@Enumerated(EnumType.STRING)
	private QuestionType type;

	@Enumerated(EnumType.STRING)
	private UploadStatus status;

	@Size(min = 2, max = 6)
	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Alternative> alternatives = new ArrayList<>();

	@NotNull
	@ManyToOne
	private Topic topic;

	@ManyToOne
	private User user;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "creation_date")
	private Date creationDate;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;

	public Question() {
	}

	public Question(String description, QuestionType type, UploadStatus status, Topic topic, User user,
			List<Alternative> alternatives) {
		this.description = description;
		this.type = type;
		this.status = status;
		this.topic = topic;
		this.user = user;
		setAlternatives(alternatives);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public UploadStatus getStatus() {
		return status;
	}

	public void setStatus(UploadStatus status) {
		this.status = status;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Alternative> getAlternatives() {
		Collections.shuffle(alternatives, new SecureRandom());
		return alternatives;
	}

	// utility method that synchronize both ends
	public void setAlternatives(List<Alternative> newAlternatives) {
		alternatives.clear();

		newAlternatives.forEach((alternative) -> {
			alternative.setQuestion(this);
			alternative.getFeedback().setAlternative(alternative);
			alternatives.add(alternative);
		});
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
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
		if (!(obj instanceof Question)) {
			return false;
		}
		Question other = (Question) obj;
		return Objects.equals(id, other.id);
	}

}
