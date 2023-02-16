package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="owner_address")
public class OwnerAddress {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="door_No._Street")
	private String door;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="pincode")
	private String pincode;
	@OneToOne(mappedBy="oaddress",cascade=CascadeType.ALL)
	private Owner owner;
	public OwnerAddress()	
	{
		//
	}
	public OwnerAddress(String door, String city, String state,String pincode) {
		super();
		this.door = door;
		this.city = city;
		this.state = state;
		this.pincode=pincode;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDoor() {
		return door;
	}
	public void setDoor(String door) {
		this.door = door;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
//	public Owner getOwner() {
//		return owner;
//	}
//	public void setOwner(Owner owner) {
//		this.owner = owner;
//	}
	
}
