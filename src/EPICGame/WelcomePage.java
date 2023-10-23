package EPICGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomePage {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel("Hello and Welcome!");
    JLabel loginSuccess = new JLabel("Login Success");
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\jkdoh\\IdeaProjects\\EPICEndeavourGame\\src\\EPICGame\\WelcomePageBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);


    WelcomePage(String userID) {

        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.welcomeLabel.setBounds(360, 40, 1000, 80);
        this.welcomeLabel.setFont(new Font((String)null, 0, 25));
        this.welcomeLabel.setForeground(new Color(20,255,255));
        this.welcomeLabel.setFont(new Font("Orbitron",Font.BOLD,50));
        this.welcomeLabel.setText("Hello " + userID + ", Welcome to the Quiz!");
        this.frame.add(this.welcomeLabel);

        this.loginSuccess.setBounds(660, 715, 500, 35);
        this.loginSuccess.setFont(new Font((String)null, 2, 25));
        this.loginSuccess.setFont(new Font("Orbitron",Font.PLAIN,30));
        this.loginSuccess.setText("Login Success");
        this.loginSuccess.setForeground(Color.green);
        this.frame.add(this.loginSuccess);

        JButton button1 = new JButton("Discrete Maths");
        button1.setBounds(640, 150, 300, 60);
        button1.setFont(new Font("Black Ops One",Font.PLAIN,25));
        button1.setBackground(new Color(0,255,255));
        button1.setFocusable(false);
        this.frame.add(button1);

        JButton button2 = new JButton("Computer Organization");
        button2.setBounds(640, 230, 300, 60);
        button2.setFont(new Font("Black Ops One",Font.PLAIN,20));
        button2.setBackground(new Color(0,255,255));
        button2.setFocusable(false);
        this.frame.add(button2);

        JButton button3 = new JButton("Computer Science");
        button3.setBounds(640, 310, 300, 60);
        button3.setFont(new Font("Black Ops One",Font.PLAIN,25));
        button3.setBackground(new Color(0,255,255));
        button3.setFocusable(false);
        this.frame.add(button3);

        JButton button4 = new JButton("Timer Game");
        button4.setBounds(640, 390, 300, 60);
        button4.setFont(new Font("Black Ops One",Font.PLAIN,25));
        button4.setBackground(new Color(0,255,255));
        button4.setFocusable(false);
        this.frame.add(button4);

        JButton button6 = new JButton("Random Game");
        button6.setBounds(640, 470, 300, 60);
        button6.setFont(new Font("Black Ops One",Font.PLAIN,25));
        button6.setBackground(new Color(0,255,255));
        button6.setFocusable(false);
        this.frame.add(button6);

        JButton button5 = new JButton("Ask Me Anything!");
        button5.setBounds(640, 550, 300, 60);
        button5.setFont(new Font("Black Ops One",Font.PLAIN,25));
        button5.setBackground(new Color(0,255,255));
        button5.setFocusable(false);
        this.frame.add(button5);


        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(640, 650, 150, 50);
        logoutButton.setFont(new Font("Black Ops One",Font.PLAIN,23));
        logoutButton.setBackground(new Color(0,255,255));
        logoutButton.setFocusable(false);
        this.frame.add(logoutButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(790, 650, 150, 50);
        settingsButton.setFont(new Font("Black Ops One",Font.PLAIN,23));
        settingsButton.setBackground(new Color(0,255,255));
        settingsButton.setFocusable(false);
        this.frame.add(settingsButton);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);


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
                    new RandomGame();
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
    }


    public static void main(String[] args) {
        new WelcomePage("");
    }
}
