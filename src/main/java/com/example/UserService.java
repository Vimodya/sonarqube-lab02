package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserService {

    // SECURITY ISSUE: Hardcoded credentials (intentional for lab)
    private String password = "admin123";

    // VULNERABILITY: SQL Injection (intentional)
    public void findUser(String username) throws Exception {
        Connection conn =
            DriverManager.getConnection(
                "jdbc:mysql://localhost/db",
                "root",
                password
            );

        Statement st = conn.createStatement();
        String query =
            "SELECT * FROM users WHERE name = '" + username + "'";
        st.executeQuery(query);
    }

    // SMELL: Unused method (intentional)
    public void notUsed() {
        System.out.println("I am never called");
    }

    // VULNERABILITY + RESOURCE LEAK (intentional)
    public void deleteUser(String username) throws Exception {
        // Sonar will complain: should use try-with-resources
        Connection conn =
            DriverManager.getConnection(
                "jdbc:mysql://localhost/db",
                "root",
                password
            );

        Statement st = conn.createStatement();
        String query =
            "DELETE FROM users WHERE name = '" + username + "'";
        st.execute(query);
    }
}
