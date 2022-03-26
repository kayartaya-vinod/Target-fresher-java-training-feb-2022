package com.targetindia.programs;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectToDbServer {

    public static void main(String[] args) throws Exception{
        // To get a connection to a DB server (remote/local):
        // 1. make sure that the suitable driver is loaded in the JVM (done implicitly by adding dependencies)
        // 2. Using JDBC URL to the server along with credentials, call the getConnection() of DriverManager

        // http://facebook.com:80/chat
        // jdbc:mysql://localhost:3306/target_db
        // jdbc:h2:tcp://localhost:1082/target_db
        // jdbc:sqlserver://localhost:1443/target_db
        // jdbc:oracle:thin://localhost:1521:ORCL
        String url = "jdbc:mysql://localhost:3306/target_db";
        String username = "root";
        String password = "Welcome#123";

        // interface variable "conn" will refer to an object of some class provided by the DB vendor
        // based on the URL
        Connection conn = DriverManager.getConnection(url, username, password);
        System.out.println("Got an object of type: " + conn.getClass().getName());
    }
}
