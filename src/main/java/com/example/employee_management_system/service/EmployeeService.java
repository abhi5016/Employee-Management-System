package com.example.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee_management_system.entity.Employee;
import com.example.employee_management_system.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {

		this.employeeRepository = employeeRepository;
	}

	public String createEmployee(Employee employee) {

		employeeRepository.save(employee);
		return "employee data Inserted";

	}

	public Employee fetchEmailById(String email) {
		return employeeRepository.findById(email).get();
	}

	public List<Employee> fetchAllEmployee() {
		return employeeRepository.findAll();
	}

	public String deleteEmployeeById(String email) {
		employeeRepository.deleteById(email);
		return "employee data deleted";
	}

	public String updateEmployeeById(String email, Employee employee) {
		Optional<Employee> op = employeeRepository.findById(email);
		if (op.isPresent()) {
			Employee existemployee = op.get();
			existemployee.setName(employee.getName());
			existemployee.setSalary(employee.getSalary());
			existemployee.setDepartment(employee.getDepartment());
			employeeRepository.save(existemployee);
			return "employee data updated successfully";
		}
		return "Employee Email Does Not Exist In The DataBase";

	}

	public String updateAll(Employee employee) {
		Optional<Employee> op = employeeRepository.findById(employee.getEmail());
		if (op.isPresent()) {
			Employee employeeexist = op.get();

			employeeexist.setName(employee.getName());

			employeeRepository.save(employeeexist);
			return "updated Successfully";
		}
		return "Employee Email Does Not Exist In The DataBase";

	}

}
