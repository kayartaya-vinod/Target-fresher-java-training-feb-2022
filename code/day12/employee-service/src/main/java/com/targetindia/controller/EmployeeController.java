package com.targetindia.controller;

import com.targetindia.entity.Employee;
import com.targetindia.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//@CrossOrigin
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping
    public Iterable<Employee> getAll(){ // HttpServletResponse resp) {
        // resp.addHeader("access-control-allow-origin", "*");
        // resp.addHeader("access-control-allow-methods", "*");

        return this.repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable Integer id) {
        Optional<Employee> result = repo.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }
        Map<String, Object> err = new HashMap<>();
        err.put("message", String.format("For this id '%s' we did not find any department.", id));
        err.put("timestamp", new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
