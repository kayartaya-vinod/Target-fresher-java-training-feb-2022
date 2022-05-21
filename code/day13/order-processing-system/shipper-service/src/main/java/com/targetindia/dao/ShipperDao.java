package com.targetindia.dao;

import com.targetindia.entity.Shipper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipperDao extends JpaRepository<Shipper, Integer> {
}
