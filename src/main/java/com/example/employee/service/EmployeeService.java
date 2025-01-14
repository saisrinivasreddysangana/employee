package com.example.employee.service;

import com.example.employee.dto.TaxResponse;
import com.example.employee.entity.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);

	TaxResponse calculateTax(Long id);

	Employee updateEmployee(Long id, Employee employee);

	void deleteEmployee(Long id);

	

	

}
