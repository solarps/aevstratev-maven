package HW16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/university";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final Connection connection = connect();

    private static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
