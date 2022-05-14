package com.targetindia.service;

import com.targetindia.entity.Customer;
import com.targetindia.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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

    public List<Customer> getAllCustomers(int pageNo, int pageSize){
        return repo.findAll(PageRequest.of(pageNo-1, pageSize)).toList();
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
            return repo.save(customer); // ID is null; executes an SQL INSERT command
        }
        catch(Exception ex){
            throw new ServiceException(ex);
        }
    }

    public Customer updateCustomer(Customer customer) throws ServiceException {
        if(customer.getId()==null){
            throw new ServiceException("ID is missing while it is required");
        }
        try{
            return repo.save(customer); // ID is not null; executes an SQL UPDATE command
        }
        catch (Exception ex){
            throw new ServiceException(ex);
        }
    }

    public void hardDelete(Integer id) {
        this.repo.deleteById(id);
    }

    public void softDelete(Customer customer){
        customer.setActive(false);
        this.repo.save(customer); // UPDATE
    }
}



















