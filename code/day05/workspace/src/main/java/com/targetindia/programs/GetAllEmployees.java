package com.targetindia.programs;

import com.targetindia.utils.DbUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class GetAllEmployees {

    public static void main(String[] args) throws Exception {
        String sql = "select * from employees"; // no parameters; so we can use Statement
        try (
                Connection conn = DbUtil.createConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql); // round trip the db
        ) {
            System.out.printf("%3s %-30s %-40s %15s %10s%n",
                    "e#",
                    "name",
                    "email",
                    "phone",
                    "salary");
            System.out.println("-".repeat(102));
            while(rs.next()){
                int empno = rs.getInt("empno");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                double salary = rs.getDouble("salary");

                System.out.printf("%3d %-30s %-40s %15s %10.2f%n",
                        empno,
                        firstname + " " + lastname,
                        email,
                        phone,
                        salary);
            }
        }
    }
}
