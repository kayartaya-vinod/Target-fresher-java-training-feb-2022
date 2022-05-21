package com.targetindia.controller;

import com.targetindia.dao.ShipperDao;
import com.targetindia.entity.Shipper;
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
@RequestMapping("/api/shippers")
public class ShipperController {

    @Autowired
    ShipperDao dao;


    @GetMapping
    public Iterable<Shipper> getAll() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        Optional<Shipper> result = dao.findById(id);
        if (result.isPresent()) {
            return ResponseEntity.ok(result.get());
        }

        Map<String, Object> err = new HashMap<>();
        err.put("status", 404);
        err.put("message", "No shipper data found for id: " + id);
        err.put("timestamp", new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}
