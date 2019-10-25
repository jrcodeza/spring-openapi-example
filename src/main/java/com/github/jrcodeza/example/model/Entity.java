package com.github.jrcodeza.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.jrcodeza.example.annotations.ReadOnly;

import io.swagger.v3.oas.annotations.media.Schema;

public class Entity {

	@Schema(description = "Common unique entity")
	@ReadOnly
	private String id;

	@JsonIgnore // we don't want to share this
	private String internalDatabaseId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInternalDatabaseId() {
		return internalDatabaseId;
	}

	public void setInternalDatabaseId(String internalDatabaseId) {
		this.internalDatabaseId = internalDatabaseId;
	}
}
