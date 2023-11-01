package EPICGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomePage {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello and Welcome!");
    JLabel loginSuccess = new JLabel("Login Success");
    ImageIcon backgroundImage = new ImageIcon("background.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    // Calculate the center of the screen
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int centerX = screenSize.width / 2;
    int centerY = screenSize.height / 2;

    WelcomePage(String userID) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);

        welcomeLabel.setBounds(centerX - 330, centerY - 400, 1000, 80);
        welcomeLabel.setFont(new Font("Orbitron", Font.BOLD, 50));
        welcomeLabel.setForeground(new Color(20, 255, 255));
        welcomeLabel.setText("Hello " + userID + ", Welcome to the Quiz");
        frame.add(welcomeLabel);

        loginSuccess.setBounds(centerX - 130, centerY + 330, 500, 35);
        loginSuccess.setFont(new Font("Orbitron", Font.PLAIN, 30));
        loginSuccess.setForeground(Color.GREEN);
        frame.add(loginSuccess);

        // Buttons
        JButton button1 = createButton("Discrete Maths", centerX - 150, centerY - 230);
        JButton button2 = createButton("Computer Organization", centerX - 150, centerY - 150);
        JButton button3 = createButton("Computer Science", centerX - 150, centerY - 70);
        JButton button4 = createButton("Timer Game", centerX - 150, centerY + 10);
        JButton button6 = createButton("Random Game", centerX - 150, centerY + 90);
        JButton button5 = createButton("Ask Me Anything!", centerX - 150, centerY + 170);

        JButton logoutButton = createButton("Logout", centerX - 300, centerY + 250);
        JButton settingsButton = createButton("Settings", centerX, centerY + 250);
        JButton leaderboardButton = createButton("Leaderboard", centerX + 410, centerY - 220);

        // Button actions
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String subject = "Discrete Maths";
                new DifficultyLevels(subject);
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String subject = "Computer Organization";
                new DifficultyLevels(subject);
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                String subject = "Computer Science";
                new DifficultyLevels(subject);
            }
        });

        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new TimerGame();
            }
        });

        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button5) {
                    frame.dispose();
                    new ChatGPTWidget();
                }
            }
        });

        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button6) {
                    frame.dispose();
                    new RandomGame("UsernameGoesHere");
                }
            }
        });
        logoutButton.addActionListener(new ActionListener() {
            IDandPasswords idandPasswords = new IDandPasswords();

            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == logoutButton) {
                    frame.dispose();
                    new LoginPage(this.idandPasswords.getLoginInfo());
                }
            }
        });
        settingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == settingsButton) {
                    new SettingsPage();
                }
            }
        });
        leaderboardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == leaderboardButton) {
                    new Leaderboard();
                }
            }
        });
    }

    public JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 300, 60);
        button.setFont(new Font("Black Ops One", Font.PLAIN, 25));
        button.setBackground(new Color(0, 255, 255));
        button.setFocusable(false);
        frame.add(button);
        return button;
    }

    public static void main(String[] args) {
        new WelcomePage("");
    }
}