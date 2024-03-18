package com.app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;


@Entity
@Table(name = "sellers")
public class Seller {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(length=30)
	@NotBlank(message="name must be supplied")
	private String name;
	
	private String city;
	
	@Column(unique=true)
	@NotBlank(message="Email is required")
	@Length(min=5,max=25,message="Invalid Email Length")
	@Email(message="Invalid email format")
	private String email;
	
//	@Column(length = 20,nullable = false)
//	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})")
	private String password;
	
	//@Length(max=10,min=10)
	private long phone;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_timestamp", insertable = true, updatable = false)
	private Date createdTimestamp=new Date();
	
	@Override
	public String toString() {
		return "Seller [id=" + id + ", name=" + name + ", city=" + city + ", email=" + email + ", password=" + password
				+ ", phone=" + phone + ", createdTimestamp=" + createdTimestamp + "]";
	}

	public Seller(int id, @NotBlank(message = "name must be supplied") String name, String city,
			@NotBlank(message = "Email is required") @Length(min = 5, max = 25, message = "Invalid Email Length") @Email(message = "Invalid email format") String email,
			String password, long phone, Date createdTimestamp) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.createdTimestamp = createdTimestamp;
	}

	public Seller() {
		super();
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	
}
