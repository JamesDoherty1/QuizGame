package EPICGame;

import java.sql.Connection;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        // Create a connection to the SQLite database
        Connection databaseConnection = DatabaseConnector.connect("EpicDatabase.db");

        // Check if the database connection is established before proceeding
        if (databaseConnection != null) {
            // Create a HashMap to hold login information (username and password)
            HashMap<String, String> loginInfo = new HashMap<>();
            LoginPage loginPage = new LoginPage(loginInfo);
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}
