package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LeaderboardStats {
    // GUI Components
    JFrame frame = new JFrame();
    JLabel usernameLabel = new JLabel();
    JLabel meanLabel = new JLabel();
    JLabel medianLabel = new JLabel();
    JLabel standardDeviationLabel = new JLabel();
    ImageIcon backgroundImage = new ImageIcon("images/LeaderboardStatsBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    LeaderboardStats(String username) {
        int centerX = frame.getWidth() / 2;
        int centerY = frame.getHeight() / 2;

        frame.setSize(314, 335);
        frame.setLocation(centerX + 1171, centerY + 293);
        frame.add(backgroundLabel);
        frame.setContentPane(backgroundLabel);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout((LayoutManager) null);

        // Set the username label based on the provided username
        usernameLabel.setBounds(centerX + 10, centerY - 10, 300, 60);
        usernameLabel.setForeground(new Color(20, 255, 255));
        usernameLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        usernameLabel.setText("Username: " + username);
        frame.add(usernameLabel);

        // Initialize variables to hold statistics
        double mean = 0.0;
        double median = 0.0;
        double stdev = 0.0;

        // Connect to the SQLite database and fetch statistics
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:EpicDataBase.db");
            String query = "SELECT mean, median, stdev FROM statistics WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                mean = resultSet.getDouble("mean");
                median = resultSet.getDouble("median");
                stdev = resultSet.getDouble("stdev");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update the labels with statistics
        meanLabel.setBounds(centerX + 10, centerY + 60, 300, 60);
        meanLabel.setForeground(new Color(20, 255, 255));
        meanLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        meanLabel.setText("Mean: " + mean);
        frame.add(meanLabel);

        medianLabel.setBounds(centerX + 10, centerY + 140, 300, 60);
        medianLabel.setForeground(new Color(20, 255, 255));
        medianLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        medianLabel.setText("Median: " + median);
        frame.add(medianLabel);

        standardDeviationLabel.setBounds(centerX + 10, centerY + 220, 300, 60);
        standardDeviationLabel.setForeground(new Color(20, 255, 255));
        standardDeviationLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        standardDeviationLabel.setText("Standard Deviation: " + stdev);
        frame.add(standardDeviationLabel);
    }
}
