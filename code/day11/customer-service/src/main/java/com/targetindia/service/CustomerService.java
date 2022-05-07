package com.targetindia.service;

import com.targetindia.entity.Customer;
import com.targetindia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Customer> getAllCustomers(){
        return repo.findAll();
    }

    public List<Customer> getAllCustomersByCity(String city){
        return repo.findAllByCity(city);
    }

    public List<Customer> getAllCustomersByGender(String gender){
        return repo.findAllByGender(gender);
    }
    public List<Customer> getAllCustomersByCityAndGender(String city, String gender){
        return repo.findAllByCityAndGender(city, gender);
    }

    public Customer addNewCustomer(Customer customer) throws ServiceException {
        try{
            customer.setId(null);
            return repo.save(customer);
        }
        catch(Exception ex){
            throw new ServiceException(ex);
        }
    }
}



















