package com.github.jrcodeza.example.model;

import javax.validation.constraints.Min;

public class Train extends Vehicle {

	@Min(1)
	private Integer numberOfCars;

	public Integer getNumberOfCars() {
		return numberOfCars;
	}

	public void setNumberOfCars(Integer numberOfCars) {
		this.numberOfCars = numberOfCars;
	}
}
