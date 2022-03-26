package com.targetindia.programs;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class ListAllLoadedJdbcDrivers {

    public static void main(String[] args) throws Exception{

        // JDBC API has a factory class called DriverManager, which as the name suggests, manages the "driver".
        // A "driver" is an object through which we can make SQL communication with RDBMS.

        // Class.forName("com.mysql.cj.jdbc.Driver"); // not required in the recent versions

        Enumeration<Driver> drivers = DriverManager.getDrivers();
        System.out.println("These are the drivers currently loaded in the JVM (maintained by DriverManager)");
        while(drivers.hasMoreElements()){
            Driver driver = drivers.nextElement();
            System.out.println(driver.getClass().getName());
        }


    }
}
