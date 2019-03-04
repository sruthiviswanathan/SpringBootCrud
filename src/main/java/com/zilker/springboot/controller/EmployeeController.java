package com.zilker.springboot.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zilker.springboot.beans.Employee;
import com.zilker.springboot.delegate.EmployeeDelegate;


@RestController
@RequestMapping("/employees")
public class EmployeeController {

@Autowired
EmployeeDelegate employeeDelegate;
	
	
	@GetMapping("/employee/all")
	public List <Employee> viewEmployeeDetails() {
		List <Employee> emp = new ArrayList<Employee>();
		
		emp = employeeDelegate.viewEmployeeDetails();
		
		return emp;
	}

	@GetMapping("/employee/{id}")
	public List <Employee> viewEmployeeDetailsById(@PathVariable("id") int id) {
		List <Employee> emp = new ArrayList<Employee>();
		
		emp = employeeDelegate.viewEmployeeDetailsById(id);
		
		return emp;
	}
	
	@PostMapping("/employee")
	public String registerEmployee(@RequestBody Employee employee) {
		
		System.out.println(employee);
		String message="";
		boolean flag=false;
		try {
		flag = employeeDelegate.registerEmployee(employee);
		if(flag==true) {
		 message= "success";
		}else {
			message="failed";
		}
		}catch(Exception e) {
			
		}
		
		return message;
	}

	@PutMapping("/employee/{id}")
	public String updateEmployee(@PathVariable("id") int id,@RequestBody Employee employee) {
		
		System.out.println(employee);
		String message="";
		boolean flag=false;
		try {
		flag = employeeDelegate.updateEmployee(id,employee);
		if(flag==true) {
		 message= "success";
		}else {
			message="failed";
		}
		}catch(Exception e) {
			
		}
		
		return message;
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable("id") int id) {
		
		
		String message="";
		boolean flag=false;
		try {
		flag = employeeDelegate.deleteEmployee(id);
		if(flag==true) {
		 message= "success";
		}else {
			message="failed";
		}
		}catch(Exception e) {
			
		}
		
		return message;
	}
	
}
