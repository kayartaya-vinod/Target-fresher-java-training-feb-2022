package com.targetindia.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.targetindia.entity.Employee;

// step#3 - enable writable transactions on specific functions
public interface EmployeeDao {

	// CRUD operations
	@Transactional(readOnly = false)
	public default Employee create(Employee emp) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	public default Employee findById(Integer id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Transactional(readOnly = false)
	public default Employee update(Employee emp) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Transactional(readOnly = false)
	public default void delete(Integer id) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	// QUERIES
	public default long count() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	public default List<Employee> findAll() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	public default List<Employee> findAllByLastname(String lastname) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	public default Employee findByEmail(String email) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	public default Employee findByPhone(String phone) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	public default List<Employee> findAllBySalaryRange(Double min, Double max) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

}
