package com.gutotech.fatecandoapi.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String name;

	@NotEmpty
	@Column(length = 20)
	private String code;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(length = 1000)
	private String description;

	@Column(name = "total_semesters")
	private int totalSemesters;

	@NotNull
	@ManyToOne
	private Institution institution;

	public Course() {
	}

	public Course(@NotEmpty String name, @NotEmpty String code, String imageUrl, String description, int totalSemesters,
			@NotNull Institution institution) {
		this.name = name;
		this.code = code;
		this.imageUrl = imageUrl;
		this.description = description;
		this.totalSemesters = totalSemesters;
		this.institution = institution;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTotalSemesters() {
		return totalSemesters;
	}

	public void setTotalSemesters(int totalSemesters) {
		this.totalSemesters = totalSemesters;
	}

	public Institution getInstitution() {
		return institution;
	}

	public void setInstitution(Institution institution) {
		this.institution = institution;
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
		if (!(obj instanceof Course)) {
			return false;
		}
		Course other = (Course) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
