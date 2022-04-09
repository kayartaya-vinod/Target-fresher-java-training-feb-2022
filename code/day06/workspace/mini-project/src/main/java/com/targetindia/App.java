package com.targetindia;

import com.targetindia.service.ServiceException;
import com.targetindia.ui.EmployeeUserInterface;

public class App {
    public static void main(String[] args) throws ServiceException {
        EmployeeUserInterface ui = new EmployeeUserInterface();
        ui.acceptAndAddEmployeeDetails();
    }
}
