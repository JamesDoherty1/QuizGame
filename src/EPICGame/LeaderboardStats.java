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
        frame.add(backgroundLabel);
        frame.setContentPane(backgroundLabel);
        frame.setSize(313, 337);
        frame.setLocation(1094, 235);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLayout((LayoutManager) null);

        usernameLabel.setBounds(20, 0, 1000, 80);
        usernameLabel.setForeground(new Color(20,255,255));
        usernameLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        usernameLabel.setText("Username: "); //insert userID as argument
        frame.add(usernameLabel);

        meanLabel.setBounds(20, 80, 1000, 80);
        meanLabel.setForeground(new Color(20,255,255));
        meanLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        meanLabel.setText("Games Played: "); //insert gamesPlayed as argument
        frame.add(meanLabel);

        medianLabel.setBounds(20, 160, 1000, 80);
        medianLabel.setForeground(new Color(20,255,255));
        medianLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        medianLabel.setText("Win Rate: "); //insert winRate as argument
        frame.add(medianLabel);

        standardDeviationLabel.setBounds(20, 240, 1000, 80);
        standardDeviationLabel.setForeground(new Color(20,255,255));
        standardDeviationLabel.setFont(new Font("Orbitron",Font.BOLD,20));
        standardDeviationLabel.setText("Win Rate: "); //insert winRate as argument
        frame.add(standardDeviationLabel);


    }
}
