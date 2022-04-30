package com.targetindia.service;

import com.targetindia.entity.Customer;
import com.targetindia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;

    public Customer getOneCustomerById(Integer id) throws ServiceException{
        Optional<Customer> op = repo.findById(id);
        if(op.isPresent()){
            return op.get();
        }
        return null;
    }

    public Iterable<Customer> getAllCustomers(){
        return repo.findAll();
    }

    public Iterable<Customer> getAllCustomersByCity(String city){
        return repo.findAllByCity(city);
    }

    public Iterable<Customer> getAllCustomersByGender(String gender){
        return repo.findAllByGender(gender);
    }
    public Iterable<Customer> getAllCustomersByCityAndGender(String city, String gender){
        return repo.findAllByCityAndGender(city, gender);
    }
}



















