package com.gutotech.fatecandoapi.model;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gutotech.fatecandoapi.rest.JacksonCustomMessageSerializer;

@Entity
@JsonSerialize(using = JacksonCustomMessageSerializer.class)
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Please provide a valid subject.")
	private String subject;

	@NotBlank(message = "Please provide a valid message text.")
	private String text;

	private boolean read;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "sender_id")
	private User from;

	@ManyToOne
	@JoinColumn(name = "recipient_id")
	private User to;

	public Message() {
	}

	public Message(String subject, String text, User from, User to) {
		this.subject = subject;
		this.text = text;
		this.from = from;
		this.to = to;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getFrom() {
		return from;
	}

	public void setFrom(User from) {
		this.from = from;
	}

	public User getTo() {
		return to;
	}

	public void setTo(User to) {
		this.to = to;
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
		if (!(obj instanceof Message)) {
			return false;
		}
		Message other = (Message) obj;
		return Objects.equals(id, other.id);
	}

}
