package com.knowledgewala.employee.employeeapi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.context.spi.CurrentSessionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.knowledgewala.employee.employeeapi.model.Employee;
import com.knowledgewala.employee.employeeapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employee")
	public List<Employee> get() {

		return employeeService.get();

	}

	@PostMapping("/employee")
	public void save(@RequestBody Employee employeeObj) {

		employeeService.save(employeeObj);

	}

	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable int id) {

		Employee employeeObj = employeeService.get(id);
		if (employeeObj == null) {

			throw new RuntimeException("Employee with id " + id + " is not Found.");
		}
		return employeeObj;

	}

	@DeleteMapping("/employee/{id}")
	public String delete(@PathVariable int id) {

		Employee employeeObj = employeeService.get(id);
		if (employeeObj == null) {

			throw new RuntimeException("Employee with id " + id + " is not Found.");
		}else {
			employeeService.delete(id);

			System.out.println("The Employee Deleted :" + id);

			return "The Employee Deleted :" + id;
		}

	}

}
