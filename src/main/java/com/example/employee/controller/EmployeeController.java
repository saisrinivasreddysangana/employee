package com.example.employee.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.TaxResponse;
import com.example.employee.entity.Employee;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<Employee> addEmployee(@Validated @RequestBody Employee employee) {
		return ResponseEntity.ok(service.saveEmployee(employee));
	}

	@GetMapping("/{id}/tax")
	public ResponseEntity<TaxResponse> getTaxDetails(@PathVariable Long id) {
		return ResponseEntity.ok(service.calculateTax(id));
	}

}
