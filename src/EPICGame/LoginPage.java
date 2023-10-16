package EPICGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

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
        this.frame.setDefaultCloseOperation(3);
        this.frame.setExtendedState(6);
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
