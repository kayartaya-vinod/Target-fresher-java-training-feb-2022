package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GetOneEmployeeRecord {

    public static void main(String[] args) throws Exception {

        String sql = "select * from employees where empno = ?";
        int empno = KeyboardUtil.getInt("Enter employee number to search: ");

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
        ) {
            stmt.setInt(1, empno);
            try (ResultSet rs = stmt.executeQuery();) {
                if (rs.next()) {
                    System.out.printf("Name     : %s %s%n", rs.getString("firstname"), rs.getString(3));
                    System.out.printf("Email id : %s%n", rs.getString("email"));
                    System.out.printf("Phone no : %s%n", rs.getString("phone"));
                    System.out.printf("Salary   : %.2f%n", rs.getDouble("salary"));
                } else {
                    System.out.printf("No data found for empno %s%n", empno);
                }
            }// rs.close() is called
        } // stmt.close() and conn.close() called
    }
}
