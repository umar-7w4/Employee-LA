package com.cg.service;

import java.util.List;

import com.cg.bean.Employee;
import com.cg.dao.EmployeeDao;
import com.cg.dao.EmployeeDaoImpl;

public class EmployeeServiceImple implements EmployeeService {

	
	EmployeeDao eDao=new EmployeeDaoImpl();
	@Override
	public List<Employee> printAllEmployee() {
		
		return eDao.displayAllEmployee();
	}

	@Override
	public String register(Employee e) {
		boolean b = false;
		if(e.getName().isEmpty() || e.getSalary()<0 ||e.getDomain().isEmpty())
			return "Invalid Data!";
		else
		{
			for(Employee emp:eDao.displayAllEmployee()) {
				if(emp.getEmpid()==e.getEmpid()) {
					b = true;
					break;
				}
			}
		}
		if(b) {
			return "Employee ID already exists";
		}
		else {
			return eDao.createEmployee(e);
		}	
	}
	public Employee searchEmployee(int id) {
		return eDao.findEmployee(id);
	}
	
	public String removeEmployee(int id) {
		return eDao.deleteEmployee(id);
	}
		
	public String changeSalaryEmployee(int id,double newSalary) {
		return eDao.updateSalary(id, newSalary);
	}
}
