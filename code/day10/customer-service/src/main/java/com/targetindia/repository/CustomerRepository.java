package com.targetindia.repository;

import com.targetindia.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Iterable<Customer> findAllByCity(String city);

    Iterable<Customer> findAllByGender(String gender);

    Iterable<Customer> findAllByCityAndGender(String city, String gender);

}

