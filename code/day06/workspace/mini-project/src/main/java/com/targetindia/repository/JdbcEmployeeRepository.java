package com.targetindia.repository;

import com.targetindia.entity.Employee;
import com.targetindia.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Slf4j
public class JdbcEmployeeRepository implements EmployeeRepository {

    static final String INSERT_SQL = "insert into employees values (null,?,?,?,?,?)";
    static final String UPDATE_SQL =
            "update employees set firstname=?, lastname=?, email=?, phone=?, salary=? where empno=?";

    @Override
    public Employee insert(Employee employee) throws RepositoryException {
        log.debug("Trying to insert {}", employee);
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS);
        ) {
            stmt.setString(1, employee.getFirstname());
            stmt.setString(2, employee.getLastname());
            stmt.setString(3, employee.getEmail());
            stmt.setString(4, employee.getPhone());
            stmt.setDouble(5, employee.getSalary());

            stmt.executeUpdate();

            ResultSet keys = stmt.getGeneratedKeys();
            keys.next();

            employee.setId(keys.getInt(1));
            return employee;
        } catch (Exception ex) {
            log.warn("Got an exception while trying to insert employee record", ex);
            throw new RepositoryException(ex);
        }
    }

    @Override
    public Employee findById(int id) throws RepositoryException {
        return null;
    }

    @Override
    public Employee update(Employee employee) throws RepositoryException {
        return null;
    }

    @Override
    public Employee delete(int id) throws RepositoryException {
        return null;
    }

    @Override
    public List<Employee> findAll() throws RepositoryException {
        return null;
    }

    @Override
    public Employee findByEmail(String email) throws RepositoryException {
        return null;
    }

    @Override
    public Employee findByPhone(String phone) throws RepositoryException {
        return null;
    }

    @Override
    public List<Employee> findByLastname(String lastname) throws RepositoryException {
        return null;
    }

    @Override
    public List<Employee> findBetweenSalary(double min, double max) throws RepositoryException {
        return null;
    }
}
