package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnections {

    private static final String URL = "jdbc:mysql://localhost/transportcompany?serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "5454136RbHbKk";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
