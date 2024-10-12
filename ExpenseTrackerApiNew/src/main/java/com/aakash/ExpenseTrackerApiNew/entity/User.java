package com.aakash.ExpenseTrackerApiNew.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_users")
public class User {

	private Long id;

	private String name;

	private String email;

	private String password;

	private Long age;

	private Timestamp created_At;
	private Timestamp updated_At;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String name, String email, String password, Long age, Timestamp created_At, Timestamp updated_At) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.age = age;
		this.created_At = created_At;
		this.updated_At = updated_At;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password")
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "age")
	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	@Column(name = "created_At", nullable = false, updatable = false)
	@CreationTimestamp
	public Timestamp getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Timestamp created_At) {
		this.created_At = created_At;
	}

	@Column(name = "updated_At")
	@CreationTimestamp
	public Timestamp getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Timestamp updated_At) {
		this.updated_At = updated_At;
	}

}
