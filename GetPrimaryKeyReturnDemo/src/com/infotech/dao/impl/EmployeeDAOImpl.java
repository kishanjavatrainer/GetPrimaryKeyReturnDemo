package com.infotech.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.infotech.dao.EmployeeDAO;
import com.infotech.model.Employee;
import com.infotech.util.DBUtil;
import com.mysql.jdbc.Statement;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public void createEmployees(List<Employee> employeeList) {
		
		String SQL = "INSERT INTO employee_table(employee_name,email,salary,date_of_joining,bonus)VALUES(?,?,?,?,?)";
		try(Connection connection = DBUtil.getConnection();PreparedStatement ps = connection.prepareStatement(SQL,Statement.RETURN_GENERATED_KEYS)) {
			for (Employee employee : employeeList) {
				ps.setString(1, employee.getEmployeeName());
				ps.setString(2, employee.getEmail());
				ps.setDouble(3, employee.getSalary());
				ps.setDate(4, new Date(employee.getDoj().getTime()));
				ps.setBigDecimal(5, employee.getBonus());
				
				ps.addBatch();
			}
			ps.executeBatch();
			
			ResultSet rs = ps.getGeneratedKeys();
			while (rs.next()) {
				System.out.println("Generated Employee ID:"+rs.getInt(1));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
