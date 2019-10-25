package com.github.jrcodeza.example.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.jrcodeza.OpenApiExample;

@JsonTypeInfo(
		use = JsonTypeInfo.Id.NAME,
		include = JsonTypeInfo.As.PROPERTY,
		property = "type"
)
@JsonSubTypes({
		@JsonSubTypes.Type(value = Car.class, name = "car"),
		@JsonSubTypes.Type(value = Train.class, name = "train"),
		@JsonSubTypes.Type(value = Plane.class, name = "airplane") // I used different name than class name
})
public class Vehicle extends Entity {

	@NotNull
	@OpenApiExample(name = "Vehicle Name", value = "Taxi car")
	private String name;

	@NotNull
	@OpenApiExample(name = "Vehicle Manufacturer", value = "Toyota")
	private String manufacturer;

	@NotNull
	private String model;

	private Integer manufactureYear;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getManufactureYear() {
		return manufactureYear;
	}

	public void setManufactureYear(Integer manufactureYear) {
		this.manufactureYear = manufactureYear;
	}

}
