package com.targetindia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

// @Component is a very generic annotation
// In a multi-tiered architecture, we have different layers, and for each the layers, there are specific annotations
// Service tier --> @Service
// DAO/Repository tier --> @Repository
// Web/Controller tier --> @Controller, @RestController
// Configuration classes --> @Configuration
@Repository
@PropertySource("classpath:jdbc-info.properties")
public class JdbcEmployeeDao implements EmployeeDao {

	// dependencies; being injected using the @Value annotation
	@Value("${jdbc.connection.driver-class-name}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.user}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;

	// this is another dependency
	// Connection pool is represented by a variable of type javax.sql.DataSource
	// @Autowired // dependency is automatically inject by Spring (if exists)
	DataSource dataSource;

	public JdbcEmployeeDao() {
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	private Connection createConnection() throws ClassNotFoundException, SQLException {
		
		System.out.println("dataSource in JdbcEmployeeDao is " + dataSource);
		
		if (dataSource != null) {
			
			System.out.println("returning a connection from the pool");
			return dataSource.getConnection();
		}
		
		System.out.println("dataSource is null, so we are creating a new connection.");
		
		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public long count() throws DaoException {
		try (Connection conn = this.createConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from employees")) {

			rs.next();
			return rs.getLong(1);
		} // rs, stmt and conn will be closed here
		catch (Exception ex) {
			throw new DaoException(ex);
		}
	}

}
