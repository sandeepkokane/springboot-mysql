package com.springboot.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entity.Employee;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAll() {
		List<Employee> emp = new ArrayList<>();
		employeeRepository.findAll().forEach(emp::add);
		return emp;
	}

	public Optional<Employee> getEmp(int id) {
		return employeeRepository.findById(id);
	}

	public void saveEmp(Employee employee) {
		employeeRepository.save(employee);
	}

	public Employee updateEmp(Employee employee, int id) {
		Employee emp2 = employeeRepository.save(employee);
		return emp2;
	}

	public void deleteEmp(int id) {
		employeeRepository.deleteById(id);
	}
}
