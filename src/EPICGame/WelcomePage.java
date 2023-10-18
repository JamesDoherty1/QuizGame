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

    WelcomePage(String userID) {
        this.welcomeLabel.setBounds(590, 50, 500, 35);
        this.welcomeLabel.setFont(new Font((String)null, 0, 25));
        this.welcomeLabel.setText("Hello " + userID + ", Welcome to the Quiz!");
        this.frame.add(this.welcomeLabel);

        this.loginSuccess.setBounds(670, 650, 500, 35);
        this.loginSuccess.setFont(new Font((String)null, 2, 25));
        this.loginSuccess.setText("Login Success");
        this.loginSuccess.setForeground(Color.green);
        this.frame.add(this.loginSuccess);


        JButton button1 = new JButton("Discrete Maths");
        button1.setBounds(660, 300, 200, 35);
        this.frame.add(button1);

        JButton button2 = new JButton("Computer Organization");
        button2.setBounds(660, 350, 200, 35);
        this.frame.add(button2);

        JButton button3 = new JButton("Computer Science");
        button3.setBounds(660, 400, 200, 35);
        this.frame.add(button3);

        JButton button4 = new JButton("Timer Game");
        button4.setBounds(660, 450, 200, 35);
        this.frame.add(button4);

        JButton button5 = new JButton("Chat GPT");
        button5.setBounds(660, 500, 200, 35);
        this.frame.add(button5);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(660, 600, 100, 35);
        this.frame.add(logoutButton);

        JButton settingsButton = new JButton("Settings");
        settingsButton.setBounds(760, 600, 100, 35);
        this.frame.add(settingsButton);

        this.frame.setDefaultCloseOperation(3);
        this.frame.setExtendedState(6);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);


        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new DiscreteMaths();
            }
        });

        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ComputerOrganization();
            }
        });

        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new ComputerScience();
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
                    ChatGPTWidget.main(new String[0]);
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

    private void openNewPage(String pageName) {
        JOptionPane.showMessageDialog(this.frame, "Opening " + pageName + " page.");
    }

    public static void main(String[] args) {
        new WelcomePage("");
    }
}
