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

public class LoginPage implements ActionListener {
    IDandPasswords idandPasswords = new IDandPasswords();
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign up");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel signupLabel = new JLabel("Don't have an account?");
    JLabel quizGame1 = new JLabel("The w         wizard");
    JLabel quizGame2 = new JLabel("ISE");
    JLabel madeBy = new JLabel("Made by: James Doherty & Naem Haq");
    JLabel messageLabel = new JLabel();
    ImageIcon backgroundImage = new ImageIcon("images/LoginBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    HashMap<String, String> logininfo = new HashMap();

    public LoginPage(HashMap<String, String> loginInfoOriginal) {
        this.logininfo = loginInfoOriginal;
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centreX = screenSize.width / 2;
        int centreY = screenSize.height / 2;

        this.quizGame1.setBounds(centreX - 350, centreY - 400, 1000, 100);
        this.quizGame1.setForeground(new Color(0, 255, 255));
        this.quizGame1.setFont(new Font("Orbitron", Font.PLAIN, 80));

        this.quizGame2.setBounds(centreX - 100, centreY - 400, 400, 100);
        this.quizGame2.setForeground(new Color(0, 180, 255));
        this.quizGame2.setFont(new Font("Orbitron", Font.PLAIN, 80));

        this.madeBy.setBounds(centreX + 300, centreY + 250, 700, 100);
        this.madeBy.setForeground(new Color(255, 215, 0));
        this.madeBy.setFont(new Font("Freestyle Script", Font.PLAIN, 40));

        this.userIDLabel.setBounds(centreX - 230, centreY - 200, 300, 50);
        this.userIDLabel.setForeground(new Color(0, 255, 255));
        this.userIDLabel.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.userPasswordLabel.setBounds(centreX - 230, centreY - 100, 300, 50);
        this.userPasswordLabel.setForeground(new Color(0, 255, 255));
        this.userPasswordLabel.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.signupLabel.setBounds(centreX - 130, centreY + 170, 500, 80);
        this.signupLabel.setFont(new Font("Orbitron", Font.BOLD, 20));
        this.signupLabel.setForeground(new Color(0, 255, 255));

        this.messageLabel.setBounds(centreX - 100, centreY + 100, 300, 35);
        this.messageLabel.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.userIDField.setBounds(centreX - 80, centreY - 200, 300, 50);
        this.userIDField.setBackground(new Color(0, 255, 255));
        this.userIDField.setFont(new Font("Orbitron", Font.PLAIN, 20));

        this.userPasswordField.setBounds(centreX - 80, centreY - 100, 300, 50);
        this.userPasswordField.setBackground(new Color(0, 255, 255));
        this.userPasswordField.setFont(new Font("Orbitron", Font.PLAIN, 20));

        this.loginButton.setBounds(centreX - 200, centreY, 200, 50);
        this.loginButton.setFont(new Font("Orbitron", Font.PLAIN, 30));
        this.loginButton.setBackground(new Color(0, 255, 255));
        this.loginButton.setFocusable(false);
        this.loginButton.addActionListener(this);

        this.resetButton.setBounds(centreX, centreY, 200, 50);
        this.resetButton.setFont(new Font("Orbitron", Font.PLAIN, 30));
        this.resetButton.setBackground(new Color(0, 255, 255));
        this.resetButton.setFocusable(false);
        this.resetButton.addActionListener(this);

        this.signupButton.setBounds(centreX - 150, centreY + 220, 300, 60);
        this.signupButton.setFont(new Font("Orbitron", Font.PLAIN, 40));
        this.signupButton.setBackground(new Color(0, 255, 255));
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
        this.frame.add(this.quizGame1);
        this.frame.add(this.quizGame2);
        this.frame.add(this.madeBy);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.resetButton) {
            this.userIDField.setText("");
            this.userPasswordField.setText("");
        }

        if (e.getSource() == this.loginButton) {
            String userID = this.userIDField.getText();
            String password = String.valueOf(this.userPasswordField.getPassword());

            if (login(userID, password)) {
                this.frame.dispose();
                new WelcomePage(userID);
            } else {
                this.messageLabel.setForeground(Color.red);
                this.messageLabel.setText("Login failed. Invalid username or password.");
            }
        }

        if (e.getSource() == this.signupButton) {
            this.frame.dispose();
            new SignupPage(this.idandPasswords.getLoginInfo());
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

        return false; // False if login failed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new LoginPage(new HashMap<>());
        });
    }
}
