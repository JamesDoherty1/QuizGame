package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class LoginPage implements ActionListener {
    // GUI Components
    JFrame frame = new JFrame();
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JTextField userField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");

    JButton signupButton = new JButton("Sign up");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel signupLabel = new JLabel("Don't have an account?");
    JLabel messageLabel = new JLabel();
    HashMap<String, String> logininfo = new HashMap();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        this.logininfo = loginInfoOriginal;

        this.userIDLabel.setBounds(650, 310, 75, 25);
        this.userPasswordLabel.setBounds(650, 360, 75, 25);
        this.signupLabel.setBounds(750, 450, 200, 25);

        this.messageLabel.setBounds(710, 500, 250, 35);
        this.messageLabel.setFont(new Font((String)null, 2, 25));

        this.userIDField.setBounds(720, 310, 200, 25);

        this.userPasswordField.setBounds(720, 360, 200, 25);

        this.loginButton.setBounds(720, 410, 100, 25);
        this.loginButton.setFocusable(false);
        this.loginButton.addActionListener(this);

        this.resetButton.setBounds(820, 410, 100, 25);
        this.resetButton.setFocusable(false);

        this.resetButton.addActionListener(this);
        this.signupButton.setBounds(720, 475, 200, 25);
        this.signupButton.setFocusable(false);
        this.signupButton.addActionListener(this);


        this.frame.add(this.userIDLabel);
        this.frame.add(this.userPasswordLabel);
        this.frame.add(this.signupLabel);
        this.frame.add(this.messageLabel);
        this.frame.add(this.userIDField);
        this.frame.add(this.userPasswordField);
        this.frame.add(this.loginButton);
        this.frame.add(this.resetButton);
        this.frame.add(this.signupButton);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);

    JButton signupButton = new JButton("Signup");
    JLabel notRegistered = new JLabel("Don't have an account?");
    ImageIcon backgroundImage = new ImageIcon("background.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    LoginPage(); {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        // Add GUI components, set bounds, and add action listeners
        userLabel.setBounds(570, 250, 100, 50);
        userLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        userLabel.setForeground(new Color(20, 255, 255));
        frame.add(userLabel);

        userField.setBounds(700, 250, 200, 50);
        userField.setBackground(new Color(0, 255, 255));
        userField.setFont(new Font("Orbitron", Font.BOLD, 20));
        frame.add(userField);

        passwordLabel.setBounds(570, 350, 100, 50);
        passwordLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        passwordLabel.setForeground(new Color(20, 255, 255));
        frame.add(passwordLabel);

        passwordField.setBounds(700, 350, 200, 50);
        passwordField.setBackground(new Color(0, 255, 255));
        passwordField.setFont(new Font("Orbitron", Font.BOLD, 20));
        frame.add(passwordField);

        loginButton.setBounds(610, 450, 100, 50);
        loginButton.setBackground(new Color(20, 255, 255));
        loginButton.setFont(new Font("Orbitron", Font.BOLD, 20));
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);
        frame.add(loginButton);

        resetButton.setBounds(720, 450, 100, 50);
        resetButton.setBackground(new Color(20, 255, 255));
        resetButton.setFont(new Font("Orbitron", Font.BOLD, 20));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);
        frame.add(resetButton);

        signupButton.setBounds(660, 550, 200, 50);
        signupButton.setBackground(new Color(20, 255, 255));
        signupButton.setFont(new Font("Orbitron", Font.BOLD, 20));
        signupButton.setFocusable(false);
        signupButton.addActionListener(this);
        frame.add(signupButton);

        notRegistered.setBounds(640, 600, 200, 50);
        notRegistered.setFont(new Font("Orbitron", Font.BOLD, 20));
        notRegistered.setForeground(new Color(20, 255, 255));
        frame.add(notRegistered);

        frame.add(backgroundLabel);
        frame.setVisible(true);

    }

    public LoginPage(HashMap loginInfo) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.resetButton) {
            this.userIDField.setText("");
            this.userPasswordField.setText("");
        }

        if (e.getSource() == this.loginButton) {
            String userID = this.userIDField.getText();
            String password = String.valueOf(this.userPasswordField.getPassword());
            if (this.logininfo.containsKey(userID)) {
                if (((String)this.logininfo.get(userID)).equals(password)) {
                    this.frame.dispose();
                    new WelcomePage(userID);
                } else {
                    this.messageLabel.setForeground(Color.red);
                    this.messageLabel.setText("Wrong password");
                }
            } else {
                this.messageLabel.setForeground(Color.red);
                this.messageLabel.setText("Username not found");

        if (e.getSource() == loginButton) {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());

            if (login(username, password)) {
                // Successful login, open WelcomePage
                frame.dispose();
                new WelcomePage(username);
            } else {
                JOptionPane.showMessageDialog(frame, "Login failed. Invalid username or password.");

            }
        } else if (e.getSource() == resetButton) {
            userField.setText("");
            passwordField.setText("");
        } else if (e.getSource() == signupButton) {
            frame.dispose();
            new SignupPage();
        }
    }

    // Database login function
    private boolean login(String username, String password) {
        String url = "jdbc:sqlite:EpicDatabase.db";
        String sql = "SELECT * FROM login WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(url);
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet resultSet = pstmt.executeQuery();

            return resultSet.next(); // True if login is successful
        } catch (SQLException e) {
            e.printStackTrace();
        }


        if (e.getSource() == this.signupButton) {
            this.frame.dispose();
            new SignupPage(this.idandPasswords.getLoginInfo());
        }

        return false; // False if login failed
    }


    public static void main(String[] args) {

        new LoginPage();
    }
}
