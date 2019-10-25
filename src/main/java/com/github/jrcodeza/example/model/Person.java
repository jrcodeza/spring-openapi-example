package com.github.jrcodeza.example.model;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.jrcodeza.example.annotations.VisibleInReport;

public class Person extends Owner {

	@VisibleInReport
	private String firstName;

	@VisibleInReport
	private List<String> lastNames;

	private LocalDate birthDate;

	@JsonProperty("isVip")
	private Boolean vip;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public List<String> getLastNames() {
		return lastNames;
	}

	public void setLastNames(List<String> lastNames) {
		this.lastNames = lastNames;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getVip() {
		return vip;
	}

	public void setVip(Boolean vip) {
		this.vip = vip;
	}
}
