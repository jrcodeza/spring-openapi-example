package com.github.jrcodeza.example.controller;

import com.github.jrcodeza.Response;
import com.github.jrcodeza.Responses;
import com.github.jrcodeza.example.annotations.AsyncOperation;
import com.github.jrcodeza.example.model.Owner;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/owners")
public class OwnersController {

	@PostMapping
	@Responses(
			@Response(responseCode = 201, description = "Owner created")
	)
	public Owner createOwner(@RequestBody Owner owner) {
		return owner;
	}

	@PostMapping("/{ownerId}/photo")
	@Responses(
			@Response(responseCode = 202, description = "Photo scheduled to be added")
	)
	@AsyncOperation
	public void addOwnerPhoto(@PathVariable String ownerId,
							  MultipartFile photo) {

	}
}
