package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.gutotech.fatecandoapi.model.annotation.AlternativesSize;

public class QuestionDTO {
	private Long id;

	@NotBlank
	private String description;

	@NotNull
	private List<QuestionType> types;

	private UploadStatus status;

	@AlternativesSize
	private List<AlternativeDTO> alternatives = new ArrayList<>();

	@NotNull
	private Topic topic;

	private User user;

	private Date creationDate;

	private Date updateDate;

	public QuestionDTO() {
	}

	public QuestionDTO(Question question) {
		this.id = question.getId();
		this.description = question.getDescription();
		this.types = question.getTypes();
		this.status = question.getStatus();
		this.topic = question.getTopic();
		this.user = question.getUser();
		setAlternatives(question.getAlternatives());
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

	public List<QuestionType> getTypes() {
		return types;
	}
	
	public void setTypes(List<QuestionType> types) {
		this.types = types;
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

	public List<AlternativeDTO> getAlternatives() {
		return alternatives;
	}

	public void setAlternatives(List<Alternative> newAlternatives) {
		newAlternatives.forEach((alternative) -> {
			alternatives.add(new AlternativeDTO(alternative));
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
		if (!(obj instanceof QuestionDTO)) {
			return false;
		}
		QuestionDTO other = (QuestionDTO) obj;
		return Objects.equals(id, other.id);
	}

}
