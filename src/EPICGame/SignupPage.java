package EPICGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

public class SignupPage implements ActionListener {
    IDandPasswords idandPasswords = new IDandPasswords();
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
    ImageIcon backgroundImage = new ImageIcon("images/SignupBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    HashMap<String, String> logininfo = new HashMap();

    SignupPage(HashMap<String, String> loginInfoOriginal) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.logininfo = loginInfoOriginal;

        int screenWidth = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int screenHeight = (int) java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        int labelWidth = 300;
        int labelHeight = 50;
        int textFieldWidth = 300;
        int textFieldHeight = 50;
        int buttonWidth = 200;
        int buttonHeight = 50;

        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

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
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.returnButton) {
            this.frame.dispose();
            new LoginPage(this.idandPasswords.getLoginInfo());
            // Need to keep passing ID and Password info
        }

        if (e.getSource() == this.signupButton) {
            String username = this.enterUsername.getText();
            String password1 = String.valueOf(this.enterPassword1.getPassword());
            String password2 = String.valueOf(this.enterPassword2.getPassword());

            if (this.logininfo.containsKey(username)) {
                this.usernameMessageLabel.setForeground(Color.red);
                this.usernameMessageLabel.setBounds(655, 470, 400, 35);
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
                if (!(username.isEmpty() || password1.isEmpty() || password2.isEmpty())) {
                    this.frame.dispose();
                    new WelcomePage(username);
                    this.logininfo.put(username, password1);
                } else {
                    this.usernameMessageLabel.setForeground(Color.red);
                    this.usernameMessageLabel.setBounds(680, 470, 400, 35);
                    this.usernameMessageLabel.setText("All fields must be filled");
                    this.passwordMessageLabel.setText("");
                }
            }
        }
    }
}
