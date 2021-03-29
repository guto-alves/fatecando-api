package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
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
	@Column(name = "html_content", columnDefinition = "TEXT")
	private String htmlContent;

	private boolean required;

	@Column(name = "item_order", columnDefinition = "SERIAL")
	private long itemOrder;

	@NotNull
	@Enumerated(EnumType.STRING)
	private UploadStatus status;

	@ManyToOne
	private Discipline discipline;

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

	public Topic(String name, String description, String htmlContent, UploadStatus status, Discipline discipline,
			User user) {
		this.name = name;
		this.description = description;
		this.htmlContent = htmlContent;
		this.status = status;
		this.discipline = discipline;
		this.createdBy = user;
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
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHtmlContent() {
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public long getLikes() {
		// @formatter:off
		return topicUsers.stream()
				.filter(TopicUser::isLiked)
				.count();
		// @formatter:on
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

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
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

	public TopicUser getUser() {
		String currentUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();

		return topicUsers.stream() //
				.filter(info -> info.getUser().getEmail().equals(currentUserEmail)) //
				.findFirst() //
				.orElse(new TopicUser());
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
