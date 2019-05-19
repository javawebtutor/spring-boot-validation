package com.jwt.validation.demo.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class UserRequest {

	@NotNull(message = "{user.firstName.required}")
	@Size(min = 2, max = 25, message = "{user.firstName.size}")
	private String firstNane;

	@Size(max = 25)
	private String middleName;

	@NotNull
	@Size(min = 2, max = 25)
	private String lastName;

	@NotNull
	@Email
	private String email;

	@Past
	private Date dateOfBirth;

	public String getFirstNane() {
		return firstNane;
	}

	public void setFirstNane(String firstNane) {
		this.firstNane = firstNane;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
