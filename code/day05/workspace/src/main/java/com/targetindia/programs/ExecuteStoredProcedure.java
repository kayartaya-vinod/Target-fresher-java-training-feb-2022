package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.CallableStatement;
import java.sql.Connection;

public class ExecuteStoredProcedure {
    public static void main(String[] args) throws Exception {

        // CallableStatement extends PreparedStatement
        // PreparedStatement extends Statement

        String firstname = KeyboardUtil.getString("Enter firstname: ");
        String lastname = KeyboardUtil.getString("Enter lastname: ");
        String email = KeyboardUtil.getString("Enter email: ");
        String phone = KeyboardUtil.getString("Enter phone: ");
        double salary = KeyboardUtil.getDouble("Enter salary: ");

        try (
                Connection conn = DbUtil.createConnection();
                CallableStatement stmt = conn.prepareCall("call add_emp_rec(?,?,?,?,?)")
        ) {
            stmt.setString(1, firstname);
            stmt.setString(2, lastname);
            stmt.setString(3, email);
            stmt.setString(4, phone);
            stmt.setDouble(5, salary);

            stmt.execute();
            System.out.println("Data inserted successfully!");
        }
    }
}
