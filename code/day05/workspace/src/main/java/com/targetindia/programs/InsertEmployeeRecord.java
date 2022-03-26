package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.Statement;

public class InsertEmployeeRecord {

    public static void main(String[] args) {
        String firstname = KeyboardUtil.getString("Enter firstname: ");
        String lastname = KeyboardUtil.getString("Enter lastname: ");
        String email = KeyboardUtil.getString("Enter email: ");
        String phone = KeyboardUtil.getString("Enter phone: ");
        double salary = KeyboardUtil.getDouble("Enter salary: ");

        String sql = String.format(
                "insert into employees values (null, '%s', '%s', '%s', '%s', %f)",
                firstname, lastname, email, phone, salary);

        // System.out.println("SQL = " + sql);

        try (
                Connection conn = DbUtil.createConnection(); // like a bridge that connects point a to point b
                Statement stmt = conn.createStatement(); // like a CAR to carry people from point a to point b
        ) {
            stmt.execute(sql); // execute, executeUpdate, executeQuery
            System.out.println("Data inserted successfully!");
        } // stmt.close() and conn.close() is executed automatically + conditionally
        catch (Exception ex) {
            System.out.println("Got an exception while trying to insert an employee record");
            System.out.println(ex.getMessage());
        }
    }
}
