package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leaderboard implements ActionListener {
    // GUI Components
    JFrame frame = new JFrame();
    JButton first = new JButton();
    JButton second = new JButton();
    JButton third = new JButton();
    JButton fourth = new JButton();
    JButton fifth = new JButton();

    Leaderboard() {
        int centerX = frame.getWidth() / 2;
        int centerY = frame.getHeight() / 2;

        frame.setSize(314, 335);
        frame.setLocation(centerX + 1171, centerY + 293);// Set a specific size for the frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // Use absolute layout for manual positioning

        int buttonWidth = 300;
        int buttonHeight = 60;

        first.setBounds(centerX, centerY, buttonWidth, buttonHeight);
        configureButton(first, "First");
        frame.add(first);

        second.setBounds(centerX, centerY + 60, buttonWidth, buttonHeight);
        configureButton(second, "Second");
        frame.add(second);

        third.setBounds(centerX, centerY+ 120, buttonWidth, buttonHeight);
        configureButton(third, "Third");
        frame.add(third);

        fourth.setBounds(centerX, centerY + 180, buttonWidth, buttonHeight);
        configureButton(fourth, "Fourth");
        frame.add(fourth);

        fifth.setBounds(centerX, centerY + 240, buttonWidth, buttonHeight);
        configureButton(fifth, "Fifth");
        frame.add(fifth);

        frame.setVisible(true);
    }

    private void configureButton(JButton button, String text) {
        button.setFont(new Font("Black Ops One", Font.PLAIN, 23));
        button.setBackground(new Color(20, 255, 255));
        button.setFocusable(false);
        button.addActionListener(this);
        button.setText(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == first || e.getSource() == second || e.getSource() == third ||
                e.getSource() == fourth || e.getSource() == fifth) {
            new LeaderboardStats("username");
        }
    }
}