package com.emp.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
		System.out.println("Employee List " + employeeList);

		model.addAttribute("emplist", employeeList);

		return "index";
	}

	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "new_employee";
	}
	
	 @PostMapping("/saveEmployee")
	 public String saveEmployee(@ModelAttribute("employee") Employee employee) {
	   
	     this.employeeServices.create(employee);
	     return "redirect:/";
	 }

}
