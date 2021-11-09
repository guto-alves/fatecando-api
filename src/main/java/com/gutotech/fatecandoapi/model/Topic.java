package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "topics")
public class Topic {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	@Column(length = 1000)
	private String description;

	@NotBlank
	@Column(name = "body_html", columnDefinition = "TEXT")
	private String bodyHtml;

	private boolean required;

	@Column(name = "item_order", columnDefinition = "SERIAL", insertable = false)
	private long itemOrder;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UploadStatus status;

	@ManyToOne
	private Subject subject;

	@ManyToOne
	private User createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "creation_date")
	private Date creationDate;

	@UpdateTimestamp
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "update_date")
	private Date updateDate;

	@JsonIgnore
	@OneToMany(mappedBy = "id.topic", cascade = CascadeType.ALL)
	private List<TopicUser> topicUsers = new ArrayList<>();

	@Transient
	private Topic previous;

	@Transient
	private Topic next;

	public Topic() {
	}

	public Topic(Long id) {
		this.id = id;
	}

	public Topic(@NotBlank String name, @NotBlank String description, @NotBlank String bodyHtml, boolean required,
			@NotNull UploadStatus status, Subject subject, User createdBy) {
		this.name = name;
		this.description = description;
		this.bodyHtml = bodyHtml;
		this.required = required;
		this.status = status;
		this.subject = subject;
		this.createdBy = createdBy;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name != null ? name.trim() : null;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description != null ? description.trim() : null;
	}

	public String getBodyHtml() {
		return bodyHtml;
	}

	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}

	public boolean isRequired() {
		return required;
	}

	public void setRequired(boolean required) {
		this.required = required;
	}

	public long getItemOrder() {
		return itemOrder;
	}

	public void setItemOrder(long itemOrder) {
		this.itemOrder = itemOrder;
	}

	public UploadStatus getStatus() {
		return status;
	}

	public void setStatus(UploadStatus status) {
		this.status = status;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
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

	public List<TopicUser> getTopicUsers() {
		return topicUsers;
	}

	public void setTopicUsers(List<TopicUser> topicUsers) {
		this.topicUsers = topicUsers;
	}

	public TopicUser getUserStats() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

		return topicUsers.stream() //
				.filter(info -> info.getUser().getEmail().equals(currentUserEmail)) //
				.findFirst() //
				.orElse(new TopicUser());
	}
	
	@JsonIgnore
	public List<Review> getReviews() {
		return topicUsers.stream()
				.filter(topicUser -> topicUser.getReview() != null && topicUser.getReview().getStars() != null)
				.map(topicUser -> {
					return topicUser.getReview().setUser(topicUser.getUser());
				})
				.collect(Collectors.toList());
	}
	
	public long getTotalReviews() {
		return topicUsers.stream()
					.count();
	}
	
	public Double getStars() {
		double average = getReviews()
					.stream()
					.mapToInt(Review::getStars)
					.average()
					.orElse(0.0);
	
		return average > 0 ? average : null;
	}

	public Topic getPrevious() {
		return previous;
	}

	public void setPrevious(Topic previous) {
		this.previous = previous;
	}

	public Topic getNext() {
		return next;
	}

	public void setNext(Topic next) {
		this.next = next;
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
		if (!(obj instanceof Topic)) {
			return false;
		}
		Topic other = (Topic) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", name=" + name + "]";
	}

}
