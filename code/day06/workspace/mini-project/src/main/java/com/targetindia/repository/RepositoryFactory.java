package com.targetindia.repository;

import java.util.ResourceBundle;

public final class RepositoryFactory {

    private RepositoryFactory() {
    }

    public static EmployeeRepository getEmployeeRepository() throws RepositoryException {
        try {
            ResourceBundle rb = ResourceBundle.getBundle("factory");
            String employeeRepositoryImplClass = rb.getString("employee.repository.impl.class");
            return (EmployeeRepository) Class.forName(employeeRepositoryImplClass).newInstance();
        }
        catch (Exception ex){
            throw new RepositoryException(ex);
        }
    }

}
