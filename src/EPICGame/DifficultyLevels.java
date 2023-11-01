package EPICGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DifficultyLevels {
    JFrame frame = new JFrame();
    JButton returnButton = new JButton("Return");
    JButton hardButton = new JButton("Hard");
    JButton mediumButton = new JButton("Medium");
    JButton easyButton = new JButton("Easy");
    ImageIcon backgroundImage = new ImageIcon("background.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    JLabel headerLabel = new JLabel("How Confident Are You?");

    DifficultyLevels(String subject) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.returnButton.setBounds(700, 700, 200, 70);
        this.returnButton.setFocusable(false);
        this.returnButton.setFont(new Font("Black Ops One", Font.PLAIN, 30));
        this.returnButton.setBackground(new Color(0, 255, 255));

        hardButton.setBounds(650, 500, 300, 80);
        hardButton.setFocusable(false);
        hardButton.setFont(new Font("Black Ops One", Font.PLAIN, 40));
        hardButton.setBackground(new Color(255, 0, 0));

        mediumButton.setBounds(650, 350, 300, 80);
        mediumButton.setFocusable(false);
        mediumButton.setFont(new Font("Black Ops One", Font.PLAIN, 40));
        mediumButton.setBackground(new Color(255, 130, 0));

        easyButton.setBounds(650, 200, 300, 80);
        easyButton.setFocusable(false);
        easyButton.setFont(new Font("Black Ops One", Font.PLAIN, 40));
        easyButton.setBackground(new Color(0, 255, 0));

        headerLabel.setBounds(350, 30, 1200, 100);
        headerLabel.setForeground(new Color(0, 255, 255));
        headerLabel.setFont(new Font("Black Ops One", Font.BOLD, 70));

        this.frame.add(this.returnButton);
        this.frame.add(this.hardButton);
        this.frame.add(this.mediumButton);
        this.frame.add(this.easyButton);
        this.frame.add(this.headerLabel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager) null);
        this.frame.setVisible(true);

        easyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total_questions = 2; // Set to 2 for easy difficulty
                frame.dispose();
                new DiscreteMaths("Easy", "DiscreteMaths");
            }
        });

        mediumButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total_questions = 2; // Set to 2 for medium difficulty
                frame.dispose();
                new DiscreteMaths("Medium", subject);
            }
        });

        hardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int total_questions = 2; // Set to 2 for hard difficulty
                frame.dispose();
                new DiscreteMaths("Hard", subject);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnButton) {
                    new WelcomePage("again");
                }
            }
        });
    }

    public static void main(String[] args) {
        new DifficultyLevels("Discrete Maths");
    }
}
