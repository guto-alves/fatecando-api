package com.gutotech.fatecandoapi.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
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
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Transient
	private User user;

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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}
	
	public Review setUser(User user) {
		this.user = user;
		return this;
	}

}
