package com.github.jrcodeza.example.model;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.jrcodeza.example.annotations.VisibleInReport;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Person.class, name = "person"),
		@JsonSubTypes.Type(value = Company.class, name = "company")
})
public class Owner extends Entity {

	@Pattern(regexp = "[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[A-Z0-9.-]+\\.[A-Z]{2,}")
	@VisibleInReport
	private String email;

	@Size(min = 8, max = 10)
	private String registrationNumber;

	@NotNull
	private Address address;

	@NotNull
	@Size(min = 1)
	@VisibleInReport
	private List<Vehicle> vehicles;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
}
