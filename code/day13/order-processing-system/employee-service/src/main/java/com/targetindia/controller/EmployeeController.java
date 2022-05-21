package com.targetindia.controller;

import com.targetindia.dao.EmployeeDao;
import com.targetindia.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeDao dao;


    @GetMapping
    public Iterable<Employee> getAll(){
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        Optional<Employee> result = dao.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }

        Map<String, Object> err = new HashMap<>();
        err.put("status", 404);
        err.put("message", "No employee data found for id: " + id);
        err.put("timestamp", new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
