package com.example.employee_management_system.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {

		this.employeeService = employeeService;
	}

	@PostMapping
	public String createEmployee(@Valid @RequestBody Employee employee) {

		return employeeService.createEmployee(employee);
	}

	@GetMapping("/{email}")
	public Employee fetchEmailById(@PathVariable String email) {
		return employeeService.fetchEmailById(email);
	}

	@GetMapping
	public List<Employee> fetchAllEmployee() {
		return employeeService.fetchAllEmployee();
	}

	@DeleteMapping("/{email}")
	public String deleteEmployeeById(String email) {

		return employeeService.deleteEmployeeById(email);
	}

	@PutMapping("/{email}")
	public String updateEmployeeById(@PathVariable String email, @RequestBody Employee employee) {
		return employeeService.updateEmployeeById(email, employee);
	}

	@PatchMapping("/email")
	public String updateAll(@RequestBody Employee employee) {
		return employeeService.updateAll(employee);
	}

}
