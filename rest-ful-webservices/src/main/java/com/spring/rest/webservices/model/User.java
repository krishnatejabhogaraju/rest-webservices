package com.spring.rest.webservices.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User Details")
@JsonFilter("UserFilter")
@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;

	@Size(min = 2, message = "Name should atleast have two characters")
	@ApiModelProperty(notes = "Name should Have Atleast Two Characters")
	private String name;

	@Past
	@ApiModelProperty(notes = "Only past Date")
	private Date dob;

	private String password;

	private String city;

	@OneToMany(mappedBy = "user")
	private List<Post> post;

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public User() {
	}

	public User(int id, String name, Date dob, String password, String city) {
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.password = password;
		this.city = city;
	}

}
