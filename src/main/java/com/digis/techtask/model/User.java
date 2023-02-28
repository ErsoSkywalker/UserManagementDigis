package com.digis.techtask.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@Column(nullable = false)
	private String fullname;

	@Column(nullable = false, unique = true)
	private String login;

	@Column(nullable = false)
	private LocalDate dob;

	@Column(nullable = false)
	private Character gender;


	public User(String fullname, String login, LocalDate dob, Character gender) {
		this.fullname = fullname;
		this.login = login;
		this.dob = dob;
		this.gender = gender;
	}

	@JsonIgnore
	public boolean isSomethingNull() {
		if (this.gender == null || this.dob == null || this.fullname == null || this.login == null)
			return true;
		return false;
	}

}
