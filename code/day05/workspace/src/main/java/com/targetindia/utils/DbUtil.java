package com.targetindia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class DbUtil {
    private DbUtil(){
    }

    public static Connection createConnection() throws ClassNotFoundException, SQLException {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc-info");
        String driverClassName = rb.getString("jdbc.connection.driver-class-name");
        String url = rb.getString("jdbc.connection.url");
        String user = rb.getString("jdbc.connection.user");
        String password = rb.getString("jdbc.connection.password");

        // not required in the newer versions of these drivers; but its a good practice to do so.
        Class.forName(driverClassName); // loads the specified class from the CLASSPATH into the JVM/
        return DriverManager.getConnection(url, user, password);
    }
}
