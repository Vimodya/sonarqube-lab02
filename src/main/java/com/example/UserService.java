package main.java.com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserService {

    private String password = System.getenv("DB_PASSWORD");

    public void findUser(String username) throws SQLException {
        String query = "SELECT id, name FROM users WHERE name = ?";

        try (Connection conn =
                 DriverManager.getConnection(
                     "jdbc:mysql://localhost/db",
                     "root",
                     password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.executeQuery();
        }
    }

    public void deleteUser(String username) throws SQLException {
        String query = "DELETE FROM users WHERE name = ?";

        try (Connection conn =
                 DriverManager.getConnection(
                     "jdbc:mysql://localhost/db",
                     "root",
                     password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, username);
            ps.execute();
        }
    }
}
