package com.example.employee.dto;

public class TaxResponse {

	private String employeeId;
	private String firstName;
	private String lastName;
	private double yearlySalary;
	private double tax;
	private double cess;

	public TaxResponse(String employeeId, String firstName, String lastName, double yearlySalary, double tax,
			double cess) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearlySalary = yearlySalary;
		this.tax = tax;
		this.cess = cess;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getYearlySalary() {
		return yearlySalary;
	}

	public void setYearlySalary(double yearlySalary) {
		this.yearlySalary = yearlySalary;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public double getCess() {
		return cess;
	}

	public void setCess(double cess) {
		this.cess = cess;
	}

}
