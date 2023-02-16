package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="Car_Details")
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@NotBlank(message="Brand cannot be empty")
	@Column(name="brand")
	private String brand;
	@NotBlank(message="Model cannot be empty")
	@Column(name="model")
	private String model;
	@NotBlank(message="Fuel type cannot be empty")
	@Column(name="fuel_Type")
	private String fuelType;
	@NotBlank(message="Color cannot be empty")
	@Column(name="colour")
	private String colour;
	@NotBlank(message="Seat Capacity cannot be empty")
	@Column(name="seat_Capacity")
	private String seatCapacity;
	@NotBlank(message="Year cannot be empty")
	@Column(name="year")
	private String year;
	@NotBlank(message="RC Book cannot be empty")
	@Column(name="rC_Book")
	private String rcBook;
	@NotBlank(message="Insurance Book cannot be empty")
	@Column(name="insurance_Book")
	private String insBook;
	@ManyToOne(targetEntity=Owner.class)
	@JoinColumn(name="owner_ID")
	private Owner owner;
	
	public Car()
	{
		//
	}
	public Car(String brand, String model, String fuelType, String colour, String seatCapacity, String year, String rcBook,
			String insBook) {
		super();
		this.brand = brand;
		this.model = model;
		this.fuelType = fuelType;
		this.colour = colour;
		this.seatCapacity = seatCapacity;
		this.year = year;
		this.rcBook = rcBook;
		this.insBook = insBook;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getSeatCapacity() {
		return seatCapacity;
	}
	public void setSeatCapacity(String seatCapacity) {
		this.seatCapacity = seatCapacity;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getRcBook() {
		return rcBook;
	}
	public void setRcBook(String rcBook) {
		this.rcBook = rcBook;
	}
	public String getInsBook() {
		return insBook;
	}
	public void setInsBook(String insBook) {
		this.insBook = insBook;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	
}
