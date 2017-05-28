package com.infotech.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.infotech.dao.EmployeeDAO;
import com.infotech.dao.impl.EmployeeDAOImpl;
import com.infotech.model.Employee;

public class ClientTest {

	public static void main(String[] args) {
		List<Employee> employeeList = getEmployeesList();
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.createEmployees(employeeList);
	}

	private static List<Employee> getEmployeesList() {

		Employee employee1 = new Employee();
		employee1.setBonus(new BigDecimal(290));
		employee1.setDoj(new Date());
		employee1.setEmployeeName("John");
		employee1.setEmail("john.cs2016@yahoo.com");
		employee1.setSalary(90000.00);
		
		Employee employee2 = new Employee();
		employee2.setBonus(new BigDecimal(290));
		employee2.setDoj(new Date());
		employee2.setEmployeeName("Sean");
		employee2.setEmail("sean.cs2006@yahoo.com");
		employee2.setSalary(40000.00);
		
		Employee employee3 = new Employee();
		employee3.setBonus(new BigDecimal(290));
		employee3.setDoj(new Date());
		employee3.setEmployeeName("Robin");
		employee3.setEmail("robin.s2017@yahoo.com");
		employee3.setSalary(95000.00);
		
		List<Employee> empList = new ArrayList<>();	
		empList.add(employee1);
		empList.add(employee2);
		empList.add(employee3);
		return empList;
	}

}
