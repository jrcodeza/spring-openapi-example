package com.github.jrcodeza.example.model.error;

import java.util.List;

public class ValidationError extends StandardError {

	private List<String> validationErrors;

	public List<String> getValidationErrors() {
		return validationErrors;
	}

	public void setValidationErrors(List<String> validationErrors) {
		this.validationErrors = validationErrors;
	}
}
