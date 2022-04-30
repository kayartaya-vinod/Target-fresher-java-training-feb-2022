package com.targetindia.controller;

import com.targetindia.entity.Customer;
import com.targetindia.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public Iterable<Customer> getCustomersHandler(
            @RequestParam(name="city", required = false, defaultValue = "") String city,
            @RequestParam(name="gender", required = false, defaultValue = "") String gender
    ){
        if(!city.strip().equals("") && !gender.strip().equals("")){
            return service.getAllCustomersByCityAndGender(city, gender);
        }

        if(!city.strip().equals("")){
            return service.getAllCustomersByCity(city);
        }
        if(!gender.strip().equals("")){
            return service.getAllCustomersByGender(gender);
        }
        return service.getAllCustomers();
    }


    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getOneCustomerHandler(@PathVariable Integer id) {
        Customer customer = service.getOneCustomerById(id);
        if(customer == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorInfo("No customer found with id: "+id));
        }

        return ResponseEntity.ok(customer);
    }
}
