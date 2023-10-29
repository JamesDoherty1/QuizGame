package EPICGame;

import javax.swing.*;
import java.awt.*;

public class LeaderboardStats{
    //GUI Components
    JFrame frame = new JFrame();
    JLabel usernameLabel = new JLabel();
    JLabel gamesPlayedLabel = new JLabel();
    JLabel winRateLabel = new JLabel();
    ImageIcon backgroundImage = new ImageIcon("images/LeaderboardStatsBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    LeaderboardStats() {
        frame.add(backgroundLabel);
        frame.setContentPane(backgroundLabel);
        frame.setSize(313, 337);
        frame.setLocation(1094, 235);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout((LayoutManager) null);

        usernameLabel.setBounds(20, 20, 1000, 80);
        usernameLabel.setForeground(new Color(20,255,255));
        usernameLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        usernameLabel.setText("Username: "); //insert userID as argument
        frame.add(usernameLabel);

        gamesPlayedLabel.setBounds(20, 120, 1000, 80);
        gamesPlayedLabel.setForeground(new Color(20,255,255));
        gamesPlayedLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        gamesPlayedLabel.setText("Games Played: "); //insert gamesPlayed as argument
        frame.add(gamesPlayedLabel);

        winRateLabel.setBounds(20, 220, 1000, 80);
        winRateLabel.setForeground(new Color(20,255,255));
        winRateLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        winRateLabel.setText("Win Rate: "); //insert winRate as argument
        frame.add(winRateLabel);


    }
}
