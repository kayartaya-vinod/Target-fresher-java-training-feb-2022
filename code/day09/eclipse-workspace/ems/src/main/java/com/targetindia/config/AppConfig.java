package com.targetindia.config;

import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;
import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.targetindia.entity.Employee;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "com.targetindia.controller", "com.targetindia.dao" })
@PropertySource("classpath:jdbc-info.properties")
@EnableTransactionManagement
public class AppConfig implements WebApplicationInitializer {

	// This method is automatically called by Spring library during the bootstrap of
	// the
	// application. You may consider this to be the "main" method in our earlier
	// spring
	// applications.
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		log.trace("AppConfig.onStartup() called");

		// Create spring container inside the Tomcat's Web container
		AnnotationConfigWebApplicationContext ctx;
		ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class); // all beans scanned and defined by/in AppConfig.java are loaded into this
										// spring container

		// create a servlet of type DispatcherServlet,
		// give the same to Tomcat, and give the spring container (ctx) to this
		// dispatcher servlet
		Dynamic ds = servletContext.addServlet("dispatchServlet", new DispatcherServlet(ctx));
		// load this dispatcher-servlet in advance
		// (else, it would be loaded lazily when the first request is made)
		ds.setLoadOnStartup(1);

		// instruct apache tomcat (your web container) to forward all incoming requests
		// from the clients
		// to this dispatcher-servlet
		ds.addMapping("/");

	}

	@Value("${jdbc.connection.driver-class-name}")
	private String driverClassName;
	@Value("${jdbc.connection.url}")
	private String url;
	@Value("${jdbc.connection.user}")
	private String username;
	@Value("${jdbc.connection.password}")
	private String password;
	
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		
		// if the view name is "xyz"
		// then it will be resoved to "/WEB-INF/views/" + "xyz" + ".jsp"
		// /WEB-INF/views/xyz.jsp
		
		return vr;
	}
	

	@Bean
	public HibernateTransactionManager txMgr(SessionFactory factory) {
		return new HibernateTransactionManager(factory);
		// the same factory is used by our HibernateTemplate, which is used by our
		// HibernateTemplateEmployeeDao
	}

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClassName);
		bds.setUrl(url);
		bds.setUsername(username);
		bds.setPassword(password);

		bds.setInitialSize(5);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(500);
		bds.setMaxIdle(20);
		return bds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory(DataSource ds) { // dependency injection by Spring
		LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
		lsfb.setDataSource(ds); // manual wiring by me
		lsfb.setAnnotatedClasses(Employee.class);

		Properties props = new Properties();
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		lsfb.setHibernateProperties(props);

		return lsfb;
	}

	@Bean
	public HibernateTemplate ht(SessionFactory factory) { // dependency injection by Spring
		// combines the capabilities of Hibernate's Session and Query APIs
		// this depends on SessionFactory
		return new HibernateTemplate(factory); // manual wiring by me
	}
}
