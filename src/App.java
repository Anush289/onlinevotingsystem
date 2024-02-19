import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    public static void main(String[] args) {
        try {
            // Establishing connection
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            // Creating a database named "example_db"
            createDatabase(connection, "example_db");

            // Using the created database
            connection.setCatalog("example_db");

            // Creating a table named "example_table"
            createTable(connection);

            // Closing the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to create a database
    private static void createDatabase(Connection connection, String databaseName) throws SQLException {
        Statement statement = connection.createStatement();
        statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
        System.out.println("Database created successfully.");
        statement.close();
    }

    // Method to create a table
    private static void createTable(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String createTableSQL = "CREATE TABLE IF NOT EXISTS example_table (" +
                "id INT PRIMARY KEY AUTO_INCREMENT," +
                "name VARCHAR(255) NOT NULL)";
        statement.executeUpdate(createTableSQL);
        System.out.println("Table created successfully.");
        statement.close();
    }
}
