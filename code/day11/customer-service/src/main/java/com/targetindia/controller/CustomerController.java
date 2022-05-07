package com.targetindia.controller;

import com.targetindia.entity.Customer;
import com.targetindia.entity.CustomerList;
import com.targetindia.service.CustomerService;
import com.targetindia.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping
    public CustomerList getCustomersHandler(
            @RequestParam(name = "city", required = false, defaultValue = "") String city,
            @RequestParam(name = "gender", required = false, defaultValue = "") String gender
    ) {
        if (!city.strip().equals("") && !gender.strip().equals("")) {
            List<Customer> itr = service.getAllCustomersByCityAndGender(city, gender);
            return new CustomerList(itr);
        }

        if (!city.strip().equals("")) {
            List<Customer> itr = service.getAllCustomersByCity(city);
            return new CustomerList(itr);
        }
        if (!gender.strip().equals("")) {
            List<Customer> itr = service.getAllCustomersByGender(gender);
            return new CustomerList(itr);
        }
        List<Customer> itr = service.getAllCustomers();
        return new CustomerList(itr);
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Object> getOneCustomerHandler(@PathVariable Integer id) {
        Customer customer = service.getOneCustomerById(id);
        if (customer == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorInfo("No customer found with id: " + id));
        }

        return ResponseEntity.ok(customer);
    }

    @PostMapping(produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> handlePostRequestFormData(Customer customer) {
        try {
            customer = service.addNewCustomer(customer);
            String html = "<h3>New customer data saved to db successfully!</h3>\n" +
                    "<p>New customer id is " + customer.getId() + "</p>";
            return ResponseEntity.status(HttpStatus.CREATED).body(html);
        } catch (ServiceException e) {
            String html = "<h3>New customer data could not be saved to db!</h3>\n" +
                    "<p>Error message is " + e.getMessage() + "</p>";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(html);
        }
    }
}
