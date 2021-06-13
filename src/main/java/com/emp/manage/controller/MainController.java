package com.emp.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.emp.manage.model.Employee;
import com.emp.manage.service.EmployeeServices;

import net.bytebuddy.asm.Advice.This;
@Controller
public class MainController {
	
	
	@Autowired
	private EmployeeServices employeeServices;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Employee> employeeList = this.employeeServices.getAllEmployeeList();
		System.out.println("Employee List "+employeeList);
		
		model.addAttribute("emplist",employeeList);
		
		return "index";
	}

}
