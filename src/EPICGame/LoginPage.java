package EPICGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class LoginPage implements ActionListener {
    IDandPasswords idandPasswords = new IDandPasswords();
    JFrame frame = new JFrame();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JButton signupButton = new JButton("Sign up");
    JTextField userIDField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIDLabel = new JLabel("userID:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel signupLabel = new JLabel("Don't have an account?");
    JLabel messageLabel = new JLabel();
    ImageIcon backgroundImage = new ImageIcon ("C:\\Users\\jkdoh\\IdeaProjects\\EPICEndeavourGame\\src\\EPICGame\\LoginBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    HashMap<String, String> logininfo = new HashMap();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.logininfo = loginInfoOriginal;

        this.userIDLabel.setBounds(600, 200, 75, 25);
        this.userPasswordLabel.setBounds(600, 260, 75, 25);

        this.signupLabel.setBounds(580, 610, 500, 80);
        this.signupLabel.setFont(new Font("Orbitron",Font.BOLD,30));
        this.signupLabel.setForeground(new Color(0,255,255));

        this.messageLabel.setBounds(660, 400, 250, 35);
        this.messageLabel.setFont(new Font((String)null, 2, 25));

        this.userIDField.setBounds(670, 200, 200, 25);

        this.userPasswordField.setBounds(670, 260, 200, 25);

        this.loginButton.setBounds(670, 330, 100, 25);
        this.loginButton.setFocusable(false);
        this.loginButton.addActionListener(this);

        this.resetButton.setBounds(770, 330, 100, 25);
        this.resetButton.setFocusable(false);

        this.resetButton.addActionListener(this);
        this.signupButton.setBounds(620, 675, 300, 60);
        this.signupButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        this.signupButton.setBackground(new Color(0,255,255));
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
    }

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
            }
        }

        if (e.getSource() == this.signupButton) {
            this.frame.dispose();
            new SignupPage(this.idandPasswords.getLoginInfo());
        }

    }
}
