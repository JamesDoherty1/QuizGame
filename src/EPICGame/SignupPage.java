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
    HashMap<String, String> logininfo = new HashMap();

    SignupPage(HashMap<String, String> loginInfoOriginal) {
        this.logininfo = loginInfoOriginal;
        this.usernameLabel.setBounds(600, 310, 200, 25);
        this.password1Label.setBounds(600, 360, 200, 25);
        this.password2Label.setBounds(600, 410, 200, 25);
        this.usernameMessageLabel.setBounds(650, 500, 400, 35);
        this.usernameMessageLabel.setFont(new Font((String) null, 2, 25));
        this.passwordMessageLabel.setBounds(650, 550, 400, 35);
        this.passwordMessageLabel.setFont(new Font((String) null, 2, 25));
        this.enterUsername.setBounds(720, 310, 200, 25);
        this.enterPassword1.setBounds(720, 360, 200, 25);
        this.enterPassword2.setBounds(720, 410, 200, 25);
        this.signupButton.setBounds(720, 450, 100, 25);
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
        this.frame.setLayout((LayoutManager) null);
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.returnButton) {
            this.frame.dispose();
            new LoginPage(this.idandPasswords.getLoginInfo());
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
            }
        }

    }
}
