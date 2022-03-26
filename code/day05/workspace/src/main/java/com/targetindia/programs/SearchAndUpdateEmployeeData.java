package com.targetindia.programs;

import com.targetindia.utils.DbUtil;
import com.targetindia.utils.KeyboardUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchAndUpdateEmployeeData {

    static String getNewStringFor(String fieldName, String oldVal){
        String msg = String.format("Enter value for %s: (%s) ", fieldName, oldVal);
        String newVal = KeyboardUtil.getString(msg);

        if(newVal.trim().length()==0){
            return oldVal;
        }
        return newVal;
    }

    static double getNewDoubleFor(String fieldName, double oldVal){
        String msg = String.format("Enter value for %s: (%s) ", fieldName, oldVal);
        String newVal = KeyboardUtil.getString(msg);

        if(newVal.trim().length()==0){
            return oldVal;
        }
        return Double.parseDouble(newVal);
    }

    public static void main(String[] args) throws Exception {

        String sqlSelect = "select * from employees where empno = ?";
        String sqlUpdate = "update employees set firstname=?, lastname=?, email=?, phone=?, salary=? where empno=?";
        int empno = KeyboardUtil.getInt("Enter employee number: ");

        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt1 = conn.prepareStatement(sqlSelect);
                PreparedStatement stmt2 = conn.prepareStatement(sqlUpdate);
        ) {
            stmt1.setInt(1, empno);
            try (
                    ResultSet rs = stmt1.executeQuery();
            ) {
                if(rs.next()){
                    String firstname = getNewStringFor("firstname", rs.getString("firstname"));
                    String lastname = getNewStringFor("lastname", rs.getString("lastname"));
                    String email = getNewStringFor("email", rs.getString("email"));
                    String phone = getNewStringFor("phone", rs.getString("phone"));
                    double salary = getNewDoubleFor("salary", rs.getDouble("salary"));

                    stmt2.setString(1, firstname);
                    stmt2.setString(2, lastname);
                    stmt2.setString(3, email);
                    stmt2.setString(4, phone);
                    stmt2.setDouble(5, salary);
                    stmt2.setInt(6, empno);

                    stmt2.executeUpdate();
                    System.out.println("Data updated successfully!");
                }
            }
        }
    }
}
