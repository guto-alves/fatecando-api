package com.gutotech.fatecandoapi.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Embeddable
public class Review {
	@Min(0)
	@Max(5)
	@Column(nullable = true)
	private Integer stars;

	@Column(nullable = true, length = 500)
	private String content;

	public Review() {
	}

	public Review(int stars, String content) {
		this.stars = stars;
		this.content = content;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(int rating) {
		this.stars = rating;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String comment) {
		this.content = comment;
	}

}
