package com.cg.dao;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import com.cg.bean.Employee;
import com.cg.cofig.EmployeeData;


public class EmployeeDaoImpl implements EmployeeDao{
	
	EmployeeData eD = new EmployeeData();

	@Override
	public List<Employee> displayAllEmployee() {
		return EmployeeData.getEmpList();
	}

	@Override
	public String createEmployee(Employee emp) {
		EmployeeData.getEmpList().add(emp);
		return "Employee Added!";
	}
	
	public Employee findEmployee(int id) {
		for (Employee emp: eD.empList) {
			if (emp.getEmpid()==id) {
				return emp;
			}
		}
		return null;
	}
	
	public String deleteEmployee(int id) {
		Iterator<Employee> i=eD.getEmpList().iterator();
		while(i.hasNext()) {
			if(i.next().getEmpid()==id)
				i.remove();
		}
		return "ID deleted";
	}
	
	public String updateSalary(int id, double newSalary) {
		for (Employee emp: eD.empList) {
			if (emp.getEmpid()==id) {
				emp.setSalary(newSalary);
			}
		}
		return "WoW salary updates. Congrats";
		
	}
	
}
