package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "feedbacks")
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	private String title;

	private String description;

	private boolean correct;

	@OneToOne
	private Alternative alternative;

	public Feedback() {
	}

	public Feedback(String title, String description, boolean correct) {
		this.title = title;
		this.description = description;
		this.correct = correct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Alternative getAlternative() {
		return alternative;
	}

	public void setAlternative(Alternative alternative) {
		this.alternative = alternative;
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
		if (!(obj instanceof Feedback)) {
			return false;
		}
		Feedback other = (Feedback) obj;
		return Objects.equals(id, other.id);
	}

}
