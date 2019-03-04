package com.zilker.springboot.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zilker.springboot.beans.Employee;
import com.zilker.springboot.repository.EmployeeRepository;



@Repository
public class EmployeeDao {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public boolean registerEmployee(Employee employee)  throws SQLException{
		boolean flag = false;
		Employee emp;
		try {
		
			 emp = employeeRepository.save(employee);
			 if(emp != null) {
				 flag=true;
			 }
		
			}catch(Exception e) {
				System.out.println("exception");
			
			}
		return flag;
	}
	public boolean updateEmployee(int id,Employee employee)  throws SQLException{
		boolean flag = false;
		Employee emp;
		try {
			 employee.setId(id);
			 emp = employeeRepository.save(employee);
			 if(emp != null) {
				 flag=true;
			 }
		
			}catch(Exception e) {
				System.out.println("exception");
			
			}
		return flag;
	}
	
	public boolean deleteEmployee(int id)  throws SQLException{
		boolean flag = false;
	
		try {
			
			 employeeRepository.deleteById(id);
			 flag=true;
			}catch(Exception e) {
				System.out.println("exception");
			
			}
		return flag;
	}
	
	
	
	public List <Employee>  viewEmployeeDetails() {
		List <Employee> emp = new ArrayList<Employee>();

		try {
			emp = employeeRepository.findAll();

		} catch (Exception e) {
			System.out.println("exception here");
		}
		return emp;
	}

	public List <Employee>  viewEmployeeDetailsById(int id) {
		List <Employee> emp1 = new ArrayList<Employee>();
		Optional <Employee> emp;

		try {
			emp = employeeRepository.findById(id);
			emp.ifPresent(emp1::add);

		} catch (Exception e) {
			System.out.println("exception here");
		}
		return emp1;
	}
}
