package com.spring.rest.webservices.model;

import java.util.Date;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "User Details")
public class User {

	private int id;
	
	@Size(min = 2,message = "Name should atleast have two characters")
	@ApiModelProperty(notes = "Name should Have Atleast Two Characters")
	private String name;
	
	@Past
	@ApiModelProperty(notes = "Only past Date")
	private Date dob;

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

	public User() {
	}

	public User(int id, String name, Date dob) {
		this.id = id;
		this.name = name;
		this.dob = dob;
	}

}
