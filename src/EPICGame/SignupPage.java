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

public class SignupPage implements ActionListener {
    private JFrame frame = new JFrame("Sign Up");
    private JButton signupButton = new JButton("Sign Up");
    private JButton returnButton = new JButton("Return");
    private JTextField enterUsername = new JTextField();
    private JPasswordField enterPassword1 = new JPasswordField();
    private JPasswordField enterPassword2 = new JPasswordField();
    private JLabel usernameLabel = new JLabel("Enter Username:");
    private JLabel password1Label = new JLabel("Enter Password:");
    private JLabel password2Label = new JLabel("Re-Enter Password:");
    private JLabel usernameMessageLabel = new JLabel("");
    private JLabel passwordMessageLabel = new JLabel("");
    ImageIcon backgroundImage = new ImageIcon("images/SignupBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    private int centerX;
    private int centerY;
    private int labelWidth = 300;
    private int labelHeight = 50;
    private int textFieldWidth = 300;
    private int textFieldHeight = 50;
    private int buttonWidth = 200;
    private int buttonHeight = 50;

    private HashMap<String, String> logininfo = new HashMap<>();

    public SignupPage() {
        initializeGUI();
    }

    public SignupPage(HashMap<String, String> loginInfoOriginal) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);
        this.logininfo = loginInfoOriginal;
        int screenWidth = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        centerX = screenWidth / 2;
        centerY = screenHeight / 2;

        initializeGUI();
    }

    private void initializeGUI() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        // Set the background color
        frame.getContentPane().setBackground(new Color(0, 0, 0));

        // Set the font and color for labels
        Font labelFont = new Font("Orbitron", Font.BOLD, 20);
        Color labelColor = new Color(255, 232, 0);

        // Set the font and color for error messages
        Font errorFont = new Font("Orbitron", Font.BOLD, 20);
        Color errorColor = Color.red;

        // Set the font and color for text fields
        Font textFieldFont = new Font("Black Ops One", Font.PLAIN, 20);
        Color textFieldBackgroundColor = new Color(0, 255, 255);

        // Set the font and color for buttons
        Font buttonFont = new Font("Black Ops One", Font.PLAIN, 30);
        Color buttonBackgroundColor = new Color(0, 255, 255);

        // Add GUI components and set their positions and styles

        this.usernameLabel.setBounds(centerX - 300 , centerY - 200, labelWidth, labelHeight);
        this.usernameLabel.setForeground(new Color(255, 232, 0));
        this.usernameLabel.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.password1Label.setBounds(centerX - 300, centerY - 100, labelWidth, labelHeight);
        this.password1Label.setForeground(new Color(255, 232, 0));
        this.password1Label.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.password2Label.setBounds(centerX - 300, centerY, labelWidth, labelHeight);
        this.password2Label.setForeground(new Color(255, 232, 0));
        this.password2Label.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.usernameMessageLabel.setBounds(centerX, centerY + 400, labelWidth + 200, labelHeight);
        this.usernameMessageLabel.setForeground(new Color(0, 0, 0));
        this.usernameMessageLabel.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.passwordMessageLabel.setBounds(centerX, centerY + 450, labelWidth + 400, labelHeight);
        this.passwordMessageLabel.setForeground(new Color(0, 0, 0));
        this.passwordMessageLabel.setFont(new Font("Orbitron", Font.BOLD, 20));

        this.enterUsername.setBounds(centerX - 50, centerY - 200, textFieldWidth, textFieldHeight);
        this.enterUsername.setBackground(new Color(0, 255, 255));
        this.enterUsername.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        this.enterPassword1.setBounds(centerX - 50, centerY - 100, textFieldWidth, textFieldHeight);
        this.enterPassword1.setBackground(new Color(0, 255, 255));
        this.enterPassword1.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        this.enterPassword2.setBounds(centerX - 50, centerY, textFieldWidth, textFieldHeight);
        this.enterPassword2.setBackground(new Color(0, 255, 255));
        this.enterPassword2.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        this.signupButton.setBounds(centerX - 150, centerY + 200, buttonWidth, buttonHeight);
        this.signupButton.setFont(new Font("Black Ops One", Font.PLAIN, 30));
        this.signupButton.setBackground(new Color(0, 255, 255));
        this.signupButton.setFocusable(false);
        this.signupButton.addActionListener(this);

        this.returnButton.setBounds(centerX + 50, centerY + 200, buttonWidth, buttonHeight);
        this.returnButton.setFont(new Font("Black Ops One", Font.PLAIN, 30));
        this.returnButton.setBackground(new Color(0, 255, 255));
        this.returnButton.setFocusable(false);
        this.returnButton.addActionListener(this);

        this.frame.add(this.usernameLabel);
        this.frame.add(this.password1Label);
        this.frame.add(this.password2Label);
        this.frame.add(this.usernameMessageLabel);
        this.frame.add(this.passwordMessageLabel);
        this.frame.add(this.enterUsername);
        this.frame.add(this.enterPassword1);
        this.frame.add(this.enterPassword2);
        this.frame.add(this.signupButton);
        this.frame.add(this.returnButton);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == returnButton) {
            frame.dispose();
            new LoginPage(logininfo);
        } else if (e.getSource() == signupButton) {
            String username = enterUsername.getText();
            String password = String.valueOf(enterPassword1.getPassword());
            String reenterPassword = String.valueOf(enterPassword2.getPassword());

            if (username.isEmpty() || password.isEmpty() || reenterPassword.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields.");
            } else if (!password.equals(reenterPassword)) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match.");
            } else {
                // Check if the username already exists in the database
                if (isUsernameAvailable(username)) {
                    // Username is available, insert it into the database
                    if (insertUser(username, password)) {
                        // Successful registration
                        JOptionPane.showMessageDialog(frame, "Registration successful!");
                        frame.dispose();
                        new LoginPage(logininfo); // Open the LoginPage
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registration failed. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists. Please choose a different one.");
                }
            }
        }
    }

    // Check if a username is available
    private boolean isUsernameAvailable(String username) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EpicDatabase.db");
            String query = "SELECT * FROM login WHERE username = ?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            rs = stmt.executeQuery();
            return !rs.next(); // Return true if there are no results
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Insert a new user into the database
    private boolean insertUser(String username, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DriverManager.getConnection("jdbc:sqlite:EpicDatabase.db");
            String query = "INSERT INTO login (username, password) VALUES (?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SignupPage();
        });
    }
}
