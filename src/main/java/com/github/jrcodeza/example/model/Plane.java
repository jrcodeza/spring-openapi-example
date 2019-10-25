package com.github.jrcodeza.example.model;

import javax.validation.constraints.Min;

import io.swagger.v3.oas.annotations.media.Schema;

public class Plane extends Vehicle {

	@Min(0)
	private Integer numberOfEngines;

	@Min(1)
	private Integer maximumFlyingAltitude;

	@Min(1)
	private Integer numberOfPassengers;

	@Schema(description = "Speed in knots")
	private Double speed;

	public Integer getNumberOfEngines() {
		return numberOfEngines;
	}

	public void setNumberOfEngines(Integer numberOfEngines) {
		this.numberOfEngines = numberOfEngines;
	}

	public Integer getMaximumFlyingAltitude() {
		return maximumFlyingAltitude;
	}

	public void setMaximumFlyingAltitude(Integer maximumFlyingAltitude) {
		this.maximumFlyingAltitude = maximumFlyingAltitude;
	}

	public Integer getNumberOfPassengers() {
		return numberOfPassengers;
	}

	public void setNumberOfPassengers(Integer numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}

	public Double getSpeed() {
		return speed;
	}

	public void setSpeed(Double speed) {
		this.speed = speed;
	}
}
