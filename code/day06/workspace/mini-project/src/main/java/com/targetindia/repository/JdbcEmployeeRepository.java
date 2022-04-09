package com.targetindia.repository;

import com.targetindia.entity.Employee;
import com.targetindia.utils.DbUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.ArrayList;
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
        String sql = "select * from employees where empno=?";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, id);
            try(ResultSet rs = stmt.executeQuery()){
                if(rs.next()){
                    return getEmployee(rs);
                }
                return null;
            }
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }
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
        String sql = "select * from employees";
        List<Employee> list = new ArrayList<>();
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
        ) {
                while(rs.next()){
                    list.add(getEmployee(rs));
                }
        } catch (Exception ex) {
            throw new RepositoryException(ex);
        }

        return list;
    }

    private Employee getEmployee(ResultSet rs) throws SQLException {
        Employee e = new Employee();
        e.setId(rs.getInt("empno"));
        e.setFirstname(rs.getString("firstname"));
        e.setLastname(rs.getString("lastname"));
        e.setEmail(rs.getString("email"));
        e.setPhone(rs.getString("phone"));
        e.setSalary(rs.getDouble("salary"));
        return e;
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
