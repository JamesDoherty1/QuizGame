package EPICGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnector {
    public static Connection connect(String databaseName) {
        try {
            Class.forName("org.sqlite.JDBC"); // Add this line
            String url = "jdbc:sqlite:" + databaseName;
            return DriverManager.getConnection(url);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
