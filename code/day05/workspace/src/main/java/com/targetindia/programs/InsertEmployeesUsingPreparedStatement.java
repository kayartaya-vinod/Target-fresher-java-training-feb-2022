package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertEmployeesUsingPreparedStatement {

    public static void main(String[] args) throws Exception {

        String sql = "insert into employees values (null, ?, ?, ?, ?, ?)";

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS); // 1st round trip to the db server
                // carries the sql command to the server, and the server parses, pre-compiles, stores in cache, and
                // sends the id of the stored command back to the client. This id is now stored in "stmt".
        ) {

            while(true){
                String firstname = KeyboardUtil.getString("Enter firstname: ");
                String lastname = KeyboardUtil.getString("Enter lastname: ");
                String email = KeyboardUtil.getString("Enter email: ");
                String phone = KeyboardUtil.getString("Enter phone: ");
                double salary = KeyboardUtil.getDouble("Enter salary: ");

                // prepare transportation of the values to the command in the db's cache
                stmt.setString(1, firstname);
                stmt.setString(2, lastname);
                stmt.setString(3, email);
                stmt.setString(4, phone);
                stmt.setDouble(5, salary);

                stmt.executeUpdate(); // 2nd round trip the db server (carries only values and
                // the id of the prepared sql command in the server's cache)

                // because of the flag Statement.RETURN_GENERATED_KEYS, we already have the generated key
                // retrieved from the server. It is in a ResultSet, which can be accessed via stmt.getGeneratedKeys()

                ResultSet keys = stmt.getGeneratedKeys();
                keys.next();
                int newEmpNo = keys.getInt(1);

                System.out.printf("Record inserted successfully with empno = %d%n", newEmpNo);

                String choice = KeyboardUtil.getString("Add another (yes/no): (yes) ");
                if(choice.trim().length()!=0 && !choice.equalsIgnoreCase("yes")){
                    break;
                }
            }
            System.out.println("Thank you and bye.");
        }

    }
}
