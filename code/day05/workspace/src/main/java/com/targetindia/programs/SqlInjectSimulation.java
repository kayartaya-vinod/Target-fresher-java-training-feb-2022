package com.targetindia.programs;

import com.targetindia.utils.KeyboardUtil;

public class SqlInjectSimulation {
    public static void main(String[] args) {

        // SELECT * FROM users_db.User where email='' and password=''
        String email = KeyboardUtil.getString("Enter email: "); // 0' or true --
        String password = KeyboardUtil.getString("Enter password: "); // doesn't matter

        String sql = String.format("SELECT * FROM users_db.User where email='%s' and password='%s'", email, password);
        System.out.println("SQL=" + sql);

        // to avoid this kind of SQL injection hacking, use PreparedStatement instead of Statement

    }
}
