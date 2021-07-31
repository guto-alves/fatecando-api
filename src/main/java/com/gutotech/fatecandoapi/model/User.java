package com.gutotech.fatecandoapi.model;

import java.util.ArrayList;
import java.util.Comparator;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
	@Size(min = 2)
	@Column(name = "full_name")
	private String fullName;

	@Email
	@Column(unique = true)
	private String email;

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

	@CreationTimestamp
	@Column(name = "creation_date")
	private Date creationDate;

	@Column(name = "last_login")
	private Date lastLogin;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<RewardUser> userRewards = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.user")
	private List<SubjectUser> userSubjects = new ArrayList<>();

	public User() {
	}

	public User(String fullName, String email, String password, Gender gender, Date birthDate) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
	}

	public User(String fullName, String email, String password, Gender gender, Date birthDate, List<Role> roles) {
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.roles = roles;
	}

	public User(Long id, @NotBlank @Size(min = 2) String fullName, @Email String email, String password,
			boolean enabled, Gender gender, Date birthDate, UserActivity userActivity, Date creationDate,
			Date lastLogin, List<Role> roles) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.gender = gender;
		this.birthDate = birthDate;
		this.userActivity = userActivity;
		this.creationDate = creationDate;
		this.lastLogin = lastLogin;
		this.roles = roles;
	}

	public static User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getFullName(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getGender(),
				userDTO.getBirthDate());
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
		this.fullName = fullName.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@JsonIgnore
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

	public List<SubjectUser> getUserSubjects() {
		return userSubjects;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@JsonIgnore
	public List<Subject> getSubjects() {
		userSubjects.sort((subject1, subject2) -> {
			if (subject1.getAccessDate().before(subject2.getAccessDate())) {
				return 1;
			} else if (subject1.getAccessDate().after(subject2.getAccessDate())) {
				return -1;
			}

			return 0;
		});

		return userSubjects.stream() //
				.map(SubjectUser::getSubject) //
				.collect(Collectors.toList());
	}

	public List<RewardUser> getUserRewards() {
		return userRewards.stream()
				.sorted(Comparator.comparing(RewardUser::getDate).reversed())
				.collect(Collectors.toList());
	}

	public Long getScore() {
		return userRewards.stream() //
				.mapToLong((r) -> r.getReward().getScore()) //
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
