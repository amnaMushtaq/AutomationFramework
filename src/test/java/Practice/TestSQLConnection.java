package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestSQLConnection {
    public static void main(String[] args) {
        try {
            // Load the JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=testdb;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
            Connection conn = DriverManager.getConnection(url);
            System.out.println("Connection successful!");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
