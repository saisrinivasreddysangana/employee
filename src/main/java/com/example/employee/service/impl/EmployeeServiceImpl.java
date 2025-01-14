package com.example.employee.service.impl;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee.dto.TaxResponse;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository repository;

	public EmployeeServiceImpl(EmployeeRepository repository) {
		this.repository = repository;
	}

	public Employee saveEmployee(Employee employee) {
		return repository.save(employee);
	}

	public TaxResponse calculateTax(Long employeeId) {
		Optional<Employee> employeeOpt = repository.findById(employeeId);
		if (employeeOpt.isEmpty()) {
			throw new RuntimeException("Employee not found");
		}

		Employee employee = employeeOpt.get();
		LocalDate doj = employee.getDoj();
		double salary = employee.getSalary();

		int monthsWorked = Math.max(0,
				12 - doj.getMonthValue() + (doj.getYear() == LocalDate.now().getYear() ? 0 : 12));
		double yearlySalary = salary * monthsWorked;

		double tax = 0;
		if (yearlySalary > 250000) {
			if (yearlySalary > 1000000) {
				tax += (yearlySalary - 1000000) * 0.20;
				yearlySalary = 1000000;
			}
			if (yearlySalary > 500000) {
				tax += (yearlySalary - 500000) * 0.10;
				yearlySalary = 500000;
			}
			if (yearlySalary > 250000) {
				tax += (yearlySalary - 250000) * 0.05;
			}
		}

		double cess = 0;
		if (yearlySalary > 2500000) {
			cess = (yearlySalary - 2500000) * 0.02;
		}

		return new TaxResponse(employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), yearlySalary,
				tax, cess);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
	}

}