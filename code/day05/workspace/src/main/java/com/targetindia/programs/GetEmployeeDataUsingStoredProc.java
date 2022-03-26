package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

public class GetEmployeeDataUsingStoredProc {

    public static void main(String[] args) throws Exception{
        String sql = "call get_emp_data(?, ?, ?, ?, ?, ?)";
        int empno = KeyboardUtil.getInt("Enter employee number to search: ");

        try (
                Connection conn = DbUtil.createConnection();
                CallableStatement stmt = conn.prepareCall(sql);
        ) {
            stmt.setInt(1, empno);
            stmt.registerOutParameter(2, Types.VARCHAR);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.registerOutParameter(5, Types.VARCHAR);
            stmt.registerOutParameter(6, Types.DOUBLE);

            // round trip to db server
            stmt.execute();

            String firstname = stmt.getString(2);
            String lastname = stmt.getString(3);
            String email = stmt.getString(4);
            String phone = stmt.getString(5);
            double salary = stmt.getDouble(6);

            System.out.printf("Name     : %s %s%n", firstname, lastname);
            System.out.printf("Email id : %s%n", email);
            System.out.printf("Phone no : %s%n", phone);
            System.out.printf("Salary   : %.2f%n", salary);

        }
    }
}
