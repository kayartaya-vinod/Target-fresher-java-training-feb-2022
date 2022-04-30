package com.targetindia.controller;

import com.targetindia.model.Employee;
import com.targetindia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public List<Employee> handleGetAll(){
        return service.getAll();
    }
}
