package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//JPA : Java EE specs
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.app.pojos.BaseEntity;
import com.app.pojos.PaymentCard;
import com.app.pojos.Role;
import com.app.pojos.ShoppingCart;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
//user : one , parent , inverse : since DOES NOT FK


public class UserDto extends BaseEntity {
	@Column(name = "first_name", length = 20)
	private String firstName;
	
	@Column(name = "last_name", length = 20)
	private String lastName;
	
	@Column(length = 30, unique = true) // => unique constraint
	private String email;
	
	@Column(length = 20, nullable = false) // => NOT NULL
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	
	@Enumerated(EnumType.STRING) // => col : varchar => enum const name
	@Column(name = "user_role", length = 20)
	private Role userRole;
	
	@Column(name="mobile_no", unique = true, nullable = false)
	private Long mobileNo;
	
	private LocalDate dob;
	
	

	public UserDto() {
		// TODO Auto-generated constructor stub
	}

	public UserDto(String firstName, String lastName, String email, String password, LocalDate dob, Long mobileNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.userRole = Role.CUSTOMER;
		this.dob = dob;
		this.mobileNo = mobileNo;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	
	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}


	@Override
	public String toString() {
		return "User Id " + getId() + " [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userRole=" + userRole + ", dob=" + dob + "]";
	}

}
