package com.github.jrcodeza.example.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.github.jrcodeza.example.annotations.VisibleInReport;

public class Company extends Owner {

	@NotNull
	@VisibleInReport
	private String name;

	@Size(min = 10, max = 10)
	private String taxNumber;

	@Min(1)
	private Integer numberOfEmployees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public Integer getNumberOfEmployees() {
		return numberOfEmployees;
	}

	public void setNumberOfEmployees(Integer numberOfEmployees) {
		this.numberOfEmployees = numberOfEmployees;
	}
}
