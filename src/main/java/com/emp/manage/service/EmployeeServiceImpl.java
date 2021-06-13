package com.emp.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.manage.model.Employee;
import com.emp.manage.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeServices {
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmployeeList() {
		
		return this.empRepo.findAll();
	}

}
