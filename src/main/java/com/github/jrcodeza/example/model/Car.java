package com.github.jrcodeza.example.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.github.jrcodeza.OpenApiExample;

@OpenApiExample(name = "car", key = "car_example")
public class Car extends Vehicle {

	@Min(0)
	private Integer numberOfDoors;

	private Integer maxSpeed;

	@NotNull
	private CarType carType;

	public Integer getNumberOfDoors() {
		return numberOfDoors;
	}

	public void setNumberOfDoors(Integer numberOfDoors) {
		this.numberOfDoors = numberOfDoors;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}
}
