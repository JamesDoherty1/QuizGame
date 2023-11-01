package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignupPage implements ActionListener {
    // GUI components
    JFrame frame = new JFrame();
    JButton signupButton = new JButton("Sign Up");
    JButton returnButton = new JButton("Return");
    JTextField enterUsername = new JTextField();
    JPasswordField enterPassword1 = new JPasswordField();
    JPasswordField enterPassword2 = new JPasswordField();
    JLabel usernameLabel = new JLabel("Enter Username:");
    JLabel password1Label = new JLabel("Enter Password:");
    JLabel password2Label = new JLabel("Re-Enter Password:");
    JLabel usernameMessageLabel = new JLabel("");
    JLabel passwordMessageLabel = new JLabel("");

    HashMap<String, String> logininfo = new HashMap();

    SignupPage(HashMap<String, String> loginInfoOriginal) {
        this.logininfo = loginInfoOriginal;
        this.usernameLabel.setBounds(600, 310, 200, 25);
        this.password1Label.setBounds(600, 360, 200, 25);
        this.password2Label.setBounds(600, 410, 200, 25);
        this.usernameMessageLabel.setBounds(650, 500, 400, 35);
        this.usernameMessageLabel.setFont(new Font((String)null, 2, 25));
        this.passwordMessageLabel.setBounds(650, 550, 400, 35);
        this.passwordMessageLabel.setFont(new Font((String)null, 2, 25));
        this.enterUsername.setBounds(720, 310, 200, 25);
        this.enterPassword1.setBounds(720, 360, 200, 25);
        this.enterPassword2.setBounds(720, 410, 200, 25);
        this.signupButton.setBounds(720, 450, 100, 25);

    ImageIcon backgroundImage = new ImageIcon ("background.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    public SignupPage() {

        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.usernameLabel.setBounds(440, 200, 300, 50);
        this.usernameLabel.setForeground(new Color(0, 255, 255));
        this.usernameLabel.setFont(new Font("Orbitron",Font.BOLD,20));

        this.password1Label.setBounds(440, 300, 300, 50);
        this.password1Label.setForeground(new Color(0, 255, 255));
        this.password1Label.setFont(new Font("Orbitron",Font.BOLD,20));

        this.password2Label.setBounds(440, 400, 300, 50);
        this.password2Label.setForeground(new Color(0, 255, 255));
        this.password2Label.setFont(new Font("Orbitron",Font.BOLD,20));

        this.usernameMessageLabel.setForeground(new Color(0,0,0));
        this.usernameMessageLabel.setFont(new Font("Orbitron",Font.BOLD,20));

        this.passwordMessageLabel.setBounds(657, 500, 400, 35);
        this.passwordMessageLabel.setForeground(new Color(0,0,0));
        this.passwordMessageLabel.setFont(new Font("Orbitron",Font.BOLD,20));

        this.enterUsername.setBounds(670, 200, 300, 50);
        this.enterUsername.setBackground(new Color(0,255,255));
        this.enterUsername.setFont(new Font("Black Ops One",Font.PLAIN,20));

        this.enterPassword1.setBounds(670, 300, 300, 50);
        this.enterPassword1.setBackground(new Color(0,255,255));
        this.enterPassword1.setFont(new Font("Black Ops One",Font.PLAIN,20));

        this.enterPassword2.setBounds(670, 400, 300, 50);
        this.enterPassword2.setBackground(new Color(0,255,255));
        this.enterPassword2.setFont(new Font("Black Ops One",Font.PLAIN,20));

        this.signupButton.setBounds(620, 550, 200, 50);
        this.signupButton.setFont(new Font("Black Ops One",Font.PLAIN,30));
        this.signupButton.setBackground(new Color(0,255,255));

        this.signupButton.setFocusable(false);
        this.signupButton.addActionListener(this);
        this.returnButton.setBounds(820, 450, 100, 25);
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

        this.frame.setDefaultCloseOperation(3);
        this.frame.setExtendedState(6);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.returnButton) {
            this.frame.dispose();
            new LoginPage(this.idandPasswords.getLoginInfo());

        if (e.getSource() == signupButton) {
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
                        new LoginPage(); // Open the LoginPage
                    } else {
                        JOptionPane.showMessageDialog(frame, "Registration failed. Please try again.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Username already exists. Please choose a different one.");
                }
            }
        } else if (e.getSource() == returnButton) {
            frame.dispose();
            new LoginPage();

        }
    }


        if (e.getSource() == this.signupButton) {
            String username = this.enterUsername.getText();
            String password1 = String.valueOf(this.enterPassword1.getPassword());
            String password2 = String.valueOf(this.enterPassword2.getPassword());
            if (this.logininfo.containsKey(username)) {
                this.usernameMessageLabel.setForeground(Color.red);
                this.usernameMessageLabel.setText("This username already exists!");
                this.enterUsername.setText("");
            }

            if (!password1.equals(password2)) {
                this.passwordMessageLabel.setForeground(Color.red);
                this.passwordMessageLabel.setText("The passwords don't match!");
                this.enterPassword1.setText("");
                this.enterPassword2.setText("");
            }

            if (!this.logininfo.containsKey(username) && password1.equals(password2)) {
                this.frame.dispose();
                new WelcomePage(username);
                this.logininfo.put(username, password1);


                // Check if a username is available
                private boolean isUsernameAvailable (String username){
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
                private boolean insertUser (String username, String password){
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

                public static void main (String[]args){
                    new SignupPage();
                }
            }