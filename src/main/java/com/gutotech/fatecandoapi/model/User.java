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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "full_name")
	private String fullName;

	@NotBlank
	@Column(unique = true)
	private String email;

	@NotBlank
	private String password;

	private boolean enabled;

	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "birth_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private Date birthDate;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserActivity userActivity = new UserActivity(this);

	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;

	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_login")
	private Date lastLogin;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "user_role", 
			joinColumns = @JoinColumn(name = "user_id"), 
			inverseJoinColumns = @JoinColumn(name = "role_id")
	)
	private List<Role> roles = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Reward> rewards = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.user")
	private List<SubjectUser> userDisciplines = new ArrayList<>();

	public User() {
	}

	public User(String fullName, String email, String password, Gender gender, Date birthDate, Course course) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.course = course;
	}

	public User(String fullName, String email, String password, Gender gender, Date birthDate, Course course,
			List<Role> roles) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.course = course;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public UserActivity getUserActivity() {
		return userActivity;
	}

	public void setUserActivity(UserActivity userActivity) {
		this.userActivity = userActivity;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public List<SubjectUser> getUserDisciplines() {
		return userDisciplines;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@JsonIgnore
	public List<Subject> getDisciplines() {
		userDisciplines.sort((discipline1, discipline2) -> {
			if (discipline1.getAccessDate().before(discipline2.getAccessDate())) {
				return 1;
			} else if (discipline1.getAccessDate().after(discipline2.getAccessDate())) {
				return -1;
			}

			return 0;
		});

		return userDisciplines.stream() //
				.map(SubjectUser::getDiscipline) //
				.collect(Collectors.toList());
	}

	public List<Reward> getRewards() {
		return rewards;
	}

	public Long getScore() {
		return rewards.stream() //
				.mapToLong((r) -> r.getType().getScore()) //
				.sum();
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
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}

}
