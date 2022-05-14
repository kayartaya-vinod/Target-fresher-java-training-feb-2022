package com.targetindia.controller;

import com.targetindia.entity.Department;
import com.targetindia.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository repo;

    @GetMapping
    public Iterable<Department> getAll(){
        return this.repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable String id){
        Optional<Department> result = this.repo.findById(id);
        if(result.isPresent()){
            return ResponseEntity.ok(result.get());
        }
        Map<String, Object> err = new HashMap<>();
        err.put("message", String.format("For this id '%s' we did not find any department.", id));
        err.put("timestamp", new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @PostMapping
    public ResponseEntity<Object> addNew(@RequestBody Department department){
        department.setId(null); // ensure no id is there, so that mongo-repository can create one for us
        try{
            department = this.repo.insert(department);
            return ResponseEntity.status(HttpStatus.CREATED).body(department);
        }
        catch (Exception e){
            Map<String, Object> err = new HashMap<>();
            err.put("message", e.getMessage());
            err.put("timestamp", new Date());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
        }
    }
}
