package com.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/emp")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}
	
	@GetMapping("/emp/{id}")
	public Optional<Employee> getEmp(@PathVariable int id)
	{
		return employeeService.getEmp(id);
	}
	
	@PostMapping("/emp")
	public String saveEmp(@RequestBody Employee employee) {
		employeeService.saveEmp(employee);
		return "Employee Details are saved";
	}
	
	@PutMapping("/emp/{id}")
	public Employee updateEmp(@RequestBody Employee employee,@PathVariable int id) {
		return employeeService.updateEmp(employee,id);
	}
	
	@DeleteMapping("/emp/{id}")
	public String deleteEmp(@PathVariable int id)
	{
		employeeService.deleteEmp(id);
		return "Employee Details are deleted";
	}
}
