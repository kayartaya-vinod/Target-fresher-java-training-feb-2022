package com.targetindia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.targetindia.dao.DaoException;
import com.targetindia.dao.EmployeeDao;
import com.targetindia.entity.Employee;

// combination of @Controller on the class and @ResponseBody on each handler method
@RestController // handler method's return values are resolved using content-negotiating-view-resolver automatically 
public class EmployeeRestController {

	@Autowired
	EmployeeDao dao;
	
	
	@GetMapping("/api/employees/{id}")
	public Employee getById(@PathVariable Integer id) throws DaoException {
		return dao.findById(id); 
	}
}
