package com.targetindia.controller;

import com.targetindia.model.Employee;
import com.targetindia.model.EmployeeList;
import com.targetindia.model.ErrorInfo;
import com.targetindia.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping
    public EmployeeList handleGetAll() {
        List<Employee> list = service.getAll();
        return new EmployeeList(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> handleGetOne(@PathVariable String id) {
        Employee emp = service.getById(id);
        if (emp == null) {
            // respond with 404 to the client
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorInfo("No data found for id " + id));
        }
        return ResponseEntity.ok(emp);
    }

    @PostMapping
    public ResponseEntity<Object> handlePost(@RequestBody Employee employee) {
        employee = service.addNewEmployee(employee);
        return ResponseEntity.ok(employee);
    }


}
