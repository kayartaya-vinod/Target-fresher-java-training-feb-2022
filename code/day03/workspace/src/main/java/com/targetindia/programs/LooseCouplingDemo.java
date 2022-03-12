package com.targetindia.programs;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;

@Slf4j
public class LooseCouplingDemo {

    public static void main(String[] args) throws Exception{

        // properties for connecting to the db server
        String url = "jdbc:h2:tcp://localhost/~/infosys_db_training"; // "jdbc:mysql://localhost/hr";
        String username = "root";
        String password = "Welcome#123";

        Connection conn;

        conn = DriverManager.getConnection(url, username, password);
        log.trace("conn is an instance of type {}", conn.getClass().getName());



    }
}
