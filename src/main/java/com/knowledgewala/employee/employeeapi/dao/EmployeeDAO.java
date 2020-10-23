package com.knowledgewala.employee.employeeapi.dao;

import java.util.List;

import com.knowledgewala.employee.employeeapi.model.Employee;

public interface EmployeeDAO {

	List<Employee> get();

	Employee get(int id);

	void save(Employee employee);

	void delete(int id);

}
