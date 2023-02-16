package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="Owner_Details")
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@NotBlank(message="Name cannot be empty")
	@Pattern(regexp="[A-Za-z]+",message="Invalid")
	@Column(name="name")
	private String name;
	@NotBlank(message="Email cannot be empty")
	@Pattern(regexp="[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",message="Invalid")
	@Column(name="email_Address")
	private String email;
	@Size(min = 10, max = 11, message = "Only 10 digits allowed")
	@Pattern(regexp="[0-9]{10}",message="Invalid")
	@Column(name="phone_Number")
	private String phone;
	@NotBlank(message="Aadhaar cannot be empty")
	@Pattern(regexp="[0-9]{12}",message="Invalid")
	@Column(name="aadhaar_Number")
	private String aadhar;
	@NotBlank(message="Password cannot be empty")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,15}",message="password must have digit,spl character,upper & lower cases")
	@Column(name="password")
	private String password;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_ID")
	private OwnerAddress oaddress;
	public Owner()
	{
		//
	}
	public Owner(String name, String email, String phone, String aadhar, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.aadhar = aadhar;
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAadhar() {
		return aadhar;
	}
	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public OwnerAddress getOaddress() {
		return oaddress;
	}
	public void setOaddress(OwnerAddress oaddress) {
		this.oaddress = oaddress;
	}
	
	
}
