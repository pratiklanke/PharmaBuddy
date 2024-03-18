package com.app.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;



@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique=true)
	@NotBlank(message="Email is required")
	@Length(min=5,max=25,message="Invalid Email Length")
	@Email(message="Invalid email format")
	private String email;
	
//	@Column(length = 20,nullable = false)
//	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;
	
	@Column(length=30)
	@NotBlank(message="name must be supplied")
	private String uname;

	public Admin() {
		super();
	}

	public Admin(int id,
			@NotBlank(message = "Email is required") @Length(min = 5, max = 25, message = "Invalid Email Length") @Email(message = "Invalid email format") String email,
			String password, @NotBlank(message = "name must be supplied") String uname) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.uname = uname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
	
	
}
