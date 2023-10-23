package EPICGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Load the SQLite JDBC driver
            Class.forName("org.sqlite.JDBC");

            // Database file path
            String dbPath = "DATABASE.sql";

            // JDBC URL for SQLite
            String url = "jdbc:sqlite:" + dbPath;

            // Create a connection to the database
            connection = DriverManager.getConnection(url);

            // Query to retrieve questions and answer choices
            String query = "SELECT id, question, correct_answer, choice1, choice2, choice3, choice4 FROM quiz_questions ORDER BY id";

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            Scanner scanner = new Scanner(System.in);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String question = resultSet.getString("question");
                String correctAnswer = resultSet.getString("correct_answer");

                // Create a list to hold the answer choices
                List<String> choices = new ArrayList<>();
                choices.add(resultSet.getString("choice1"));
                choices.add(resultSet.getString("choice2"));
                choices.add(resultSet.getString("choice3"));
                choices.add(resultSet.getString("choice4"));

                // Shuffle the answer choices
                Collections.shuffle(choices);

                // Present the question and shuffled answer choices
                System.out.println("Question " + id + ": " + question);
                for (int i = 0; i < choices.size(); i++) {
                    System.out.println((char) ('A' + i) + ". " + choices.get(i));
                }

                // Find the index of the correct answer in the shuffled choices
                int correctIndex = choices.indexOf(correctAnswer);

                // Prompt the user for their answer
                System.out.print("Your answer (A/B/C/D): ");
                String userAnswer = scanner.nextLine();

                // Check if the user's answer is correct
                if (userAnswer.equalsIgnoreCase(String.valueOf((char) ('A' + correctIndex)))) {
                    System.out.println("Correct!\n");
                } else {
                    System.out.println("Incorrect. The correct answer is " + (char) ('A' + correctIndex) + ".\n");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
