package com.targetindia.programs;

import com.targetindia.utils.DbUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class InsertRecordsInBatches {

    public static void main(String[] args) throws Exception {
        String sql = "insert into employees values (null, ?, ?, ?, ?, ?)";
        String filename = "employees.csv";
        try (
                Connection conn = DbUtil.createConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                FileReader reader = new FileReader(filename);
                BufferedReader in = new BufferedReader(reader);
        ) {
            String line = in.readLine(); // first line is a header; we can ignore the same for this app
            while ((line = in.readLine()) != null) {
                String[] arr = line.split(",");
                String firstname = arr[0];
                String lastname = arr[1];
                String email = arr[2];
                String phone = arr[3];
                double salary = Double.valueOf(arr[4]);

                stmt.setString(1, firstname);
                stmt.setString(2, lastname);
                stmt.setString(3, email);
                stmt.setString(4, phone);
                stmt.setDouble(5, salary);

                stmt.addBatch(); // adds the parameter values into a batch of values
            }

            // make the round trips to the db
            stmt.executeBatch(); // sends a bunch of data in each batch
            System.out.println("Records inserted successfully!");
        } // resource closure here
    }
}
