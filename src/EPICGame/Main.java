package EPICGame;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        // Create a connection to the SQLite database
        Connection databaseConnection = DatabaseConnector.connect("EpicDatabase.db");

        // Check if the database connection is established before proceeding
        if (databaseConnection != null) {
            LoginPage loginPage = new LoginPage();
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}