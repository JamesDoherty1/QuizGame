package EPICGame;

import javax.swing.*;
import java.awt.*;

public class LeaderboardStats{
    //GUI Components
    JFrame frame = new JFrame();
    JLabel usernameLabel = new JLabel();
    JLabel meanLabel = new JLabel();
    JLabel medianLabel = new JLabel();
    JLabel standardDeviationLabel = new JLabel();
    ImageIcon backgroundImage = new ImageIcon("images/LeaderboardStatsBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);


    LeaderboardStats() {
        int centerX = frame.getWidth() / 2;
        int centerY = frame.getHeight() / 2;

        frame.setSize(314, 335);
        frame.setLocation(centerX + 1171, centerY + 293);
        frame.add(backgroundLabel);
        frame.setContentPane(backgroundLabel);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout((LayoutManager) null);

        usernameLabel.setBounds(centerX + 10, centerY - 10, 300, 60);
        usernameLabel.setForeground(new Color(20,255,255));
        usernameLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        usernameLabel.setText("Username: "); //insert userID as argument
        frame.add(usernameLabel);

        meanLabel.setBounds(centerX + 10, centerY + 60, 300, 60);
        meanLabel.setForeground(new Color(20,255,255));
        meanLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        meanLabel.setText("Games Played: "); //insert gamesPlayed as argument
        frame.add(meanLabel);

        medianLabel.setBounds(centerX + 10, centerY + 140, 300, 60);
        medianLabel.setForeground(new Color(20,255,255));
        medianLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        medianLabel.setText("Win Rate: "); //insert winRate as argument
        frame.add(medianLabel);

        standardDeviationLabel.setBounds(centerX + 10, centerY + 220, 300, 60);
        standardDeviationLabel.setForeground(new Color(20,255,255));
        standardDeviationLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        standardDeviationLabel.setText("Win Rate: "); //insert winRate as argument
        frame.add(standardDeviationLabel);


    }
}
