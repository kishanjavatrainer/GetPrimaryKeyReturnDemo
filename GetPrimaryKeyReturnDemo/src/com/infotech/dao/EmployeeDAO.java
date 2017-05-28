package com.infotech.dao;

import java.util.List;

import com.infotech.model.Employee;

public interface EmployeeDAO {
	public abstract void createEmployees(List<Employee> employeeList);
}
