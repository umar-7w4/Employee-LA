package com.cg.service;

import java.util.List;

import com.cg.bean.Employee;

public interface EmployeeService {
	List<Employee> printAllEmployee();
	String register(Employee e);
	Employee searchEmployee(int id);
}
