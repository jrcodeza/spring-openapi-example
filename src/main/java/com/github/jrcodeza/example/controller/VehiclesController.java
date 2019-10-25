package com.github.jrcodeza.example.controller;

import java.util.List;

import com.github.jrcodeza.Header;
import com.github.jrcodeza.OpenApiExample;
import com.github.jrcodeza.OpenApiExamples;
import com.github.jrcodeza.OpenApiIgnore;
import com.github.jrcodeza.Response;
import com.github.jrcodeza.Responses;
import com.github.jrcodeza.example.model.Car;
import com.github.jrcodeza.example.model.Vehicle;
import com.github.jrcodeza.example.model.error.StandardError;
import com.github.jrcodeza.example.model.error.ValidationError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vehicles")
public class VehiclesController {

	@PostMapping
	@Responses({
			@Response(responseCode = 201, description = "Vehicle created", responseBody = Vehicle.class),
			@Response(responseCode = 400, description = "Validation error", responseBody = ValidationError.class),
			@Response(responseCode = 500, description = "Unexpected error", responseBody = StandardError.class)
	})
	public Vehicle createVehicle(
			@OpenApiExamples({
					@OpenApiExample(name = "plane", key = "plane_example"),
					@OpenApiExample(name = "standard", key = "train_example")
			}) @RequestBody Vehicle vehicle) {
		// do nothing
		return vehicle;
	}

	@PutMapping("/{vehicleId}")
	@Responses({
			@Response(responseCode = 200, description = "Vehicle replaces", responseBody = Vehicle.class,
					headers = {@Header(name = "ETag")}),
			@Response(responseCode = 415, description = "Precondition failed", responseBody = StandardError.class),
			@Response(responseCode = 400, description = "Validation error", responseBody = ValidationError.class),
			@Response(responseCode = 500, description = "Unexpected error", responseBody = StandardError.class)
	})
	public Vehicle replaceVehicle(@RequestHeader("If-Match") String ifMatchHeader,
								  @PathVariable String vehicleId,
								  @RequestBody Vehicle vehicle) {
		return vehicle;
	}

	@GetMapping
	public List<Vehicle> getVehicles(@RequestParam String manufacturer) {
		return null;
	}

	@GetMapping("/cars")
	public List<Car> getCars(@RequestParam String manufacturer) {
		return null;
	}

	@GetMapping("/do-not-generate")
	@OpenApiIgnore
	public Vehicle doNotGenerate() {
		return null;
	}

}
