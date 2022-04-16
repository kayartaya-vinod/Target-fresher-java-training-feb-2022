package com.targetindia.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.targetindia.entity.Employee;

@SuppressWarnings({ "unchecked", "deprecation" })
@Repository("htDao") // helps in component-scan
public class HibernateTemplateEmployeeDao implements EmployeeDao {

	@Autowired
	HibernateTemplate template; // automatically injects an object of HibernateTemplate class

	@Override
	public Employee create(Employee emp) throws DaoException { // transaction begins here
		template.persist(emp);
		return emp;
	} // transaction ends here either by commit or rollback (in case of an exception)

	@Override
	public Employee findById(Integer id) throws DaoException {
		return template.get(Employee.class, id);
	}

	@Override
	public Employee update(Employee emp) throws DaoException {
		return template.merge(emp);
	}

	@Override
	public void delete(Integer id) throws DaoException {
		template.delete(findById(id));
	}

	@Override
	public List<Employee> findAll() throws DaoException {
		return (List<Employee>) template.find("from Employee");
	}

	@Override
	public List<Employee> findAllByLastname(String lastname) throws DaoException {
		return (List<Employee>) template.find("from Employee where lastname=?0", lastname);
	}

	@Override
	public Employee findByEmail(String email) throws DaoException {
		return (Employee) template.find("from Employee where email=?0", email).get(0);
	}

	@Override
	public Employee findByPhone(String phone) throws DaoException {
		return (Employee) template.find("from Employee where phone=?0", phone).get(0);
	}

	@Override
	public List<Employee> findAllBySalaryRange(Double min, Double max) throws DaoException {
		return (List<Employee>) template.find("from Employee where salary between ?0 and ?1", min, max);
	}

}
