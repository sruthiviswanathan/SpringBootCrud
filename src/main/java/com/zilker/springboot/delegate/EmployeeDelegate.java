package com.zilker.springboot.delegate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zilker.springboot.beans.Employee;
import com.zilker.springboot.dao.EmployeeDao;

@Service
public class EmployeeDelegate {


@Autowired
EmployeeDao employeeDao;
	
public List <Employee>  viewEmployeeDetails() {
	List <Employee> emp = new ArrayList<Employee>();

	try {
		emp = employeeDao.viewEmployeeDetails();

	} catch (Exception e) {
		System.out.println("exception here");
	}
	return emp;
}


public List <Employee>  viewEmployeeDetailsById(int id) {
	List <Employee> emp = new ArrayList<Employee>();

	try {
		emp = employeeDao.viewEmployeeDetailsById(id);

	} catch (Exception e) {
		System.out.println("exception here");
	}
	return emp;
}

	
	public boolean registerEmployee(Employee employee) {
		
		boolean flag = false;
		try {
			flag = employeeDao.registerEmployee(employee);

		} catch (SQLException e) {
			System.out.println("exception here");
		}
		return flag;
	}
public boolean updateEmployee(int id ,Employee employee) {
		
		boolean flag = false;
		try {
			flag = employeeDao.updateEmployee(id,employee);

		} catch (SQLException e) {
			System.out.println("exception here");
		}
		return flag;
	}
	
public boolean deleteEmployee(int id) {
	
	boolean flag = false;
	try {
		flag = employeeDao.deleteEmployee(id);

	} catch (SQLException e) {
		System.out.println("exception here");
	}
	return flag;
}

}
