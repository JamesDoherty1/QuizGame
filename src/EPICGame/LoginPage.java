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
    JLabel userIDLabel = new JLabel("Username:");
    JLabel userPasswordLabel = new JLabel("Password:");
    JLabel signupLabel = new JLabel("Don't have an account?");
    JLabel quizGame = new JLabel("ISE Quiz Game");
    JLabel madeBy = new JLabel("Made by: James Doherty & Naem Haq");
    JLabel messageLabel = new JLabel();
    ImageIcon backgroundImage = new ImageIcon ("C:\\Users\\jkdoh\\IdeaProjects\\EPICEndeavourGame\\images\\LoginBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    HashMap<String, String> logininfo = new HashMap();

    LoginPage(HashMap<String, String> loginInfoOriginal) {
        //constructor with necessary arguments

        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);
        //Add background as a label and set to fill the page

        this.logininfo = loginInfoOriginal;

        this.quizGame.setBounds(450, 30, 800, 100);
        this.quizGame.setForeground(new Color(0,255,255));
        this.quizGame.setFont(new Font("Black Ops One",Font.BOLD,90));

        this.madeBy.setBounds(1100, 650, 800, 200);
        this.madeBy.setForeground(new Color(255,215,0));
        this.madeBy.setFont(new Font("Freestyle Script",Font.PLAIN,40));

        this.userIDLabel.setBounds(550, 210, 300, 50);
        this.userIDLabel.setForeground(new Color(0,0,0));
        this.userIDLabel.setFont(new Font("Orbitron",Font.BOLD,20));

        this.userPasswordLabel.setBounds(550, 310, 300, 50);
        this.userPasswordLabel.setForeground(new Color(0,0,0));
        this.userPasswordLabel.setFont(new Font("Orbitron",Font.BOLD,20));

        this.signupLabel.setBounds(580, 610, 500, 80);
        this.signupLabel.setFont(new Font("Orbitron",Font.BOLD,30));
        this.signupLabel.setForeground(new Color(0,255,255));

        this.messageLabel.setBounds(700, 390, 300, 35);
        this.messageLabel.setFont(new Font((String)null, 2, 25));
        this.messageLabel.setFont(new Font("Orbitron",Font.BOLD,20));

        this.userIDField.setBounds(670, 210, 300, 50);
        this.userIDField.setBackground(new Color(0,255,255));
        this.userIDField.setFont(new Font("Black Ops One",Font.PLAIN,20));

        this.userPasswordField.setBounds(670, 310, 300, 50);
        this.userPasswordField.setBackground(new Color(0,255,255));
        this.userPasswordField.setFont(new Font("Black Ops One",Font.PLAIN,20));

        this.loginButton.setBounds(570, 450, 200, 50);
        this.loginButton.setFont(new Font("Black Ops One",Font.PLAIN,30));
        this.loginButton.setBackground(new Color(0,255,255));
        this.loginButton.setFocusable(false);
        this.loginButton.addActionListener(this);

        this.resetButton.setBounds(770, 450, 200, 50);
        this.resetButton.setFont(new Font("Black Ops One",Font.PLAIN,30));
        this.resetButton.setBackground(new Color(0,255,255));
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
        this.frame.add(this.quizGame);
        this.frame.add(this.madeBy);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager)null);
        this.frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.resetButton) {
            this.userIDField.setText("");
            this.userPasswordField.setText("");
            //re-set textbox
        }

        if (e.getSource() == this.loginButton) {
            String userID = this.userIDField.getText();
            String password = String.valueOf(this.userPasswordField.getPassword());
            if (this.logininfo.containsKey(userID)) {
                if (((String)this.logininfo.get(userID)).equals(password)) {
                    this.frame.dispose();
                    new WelcomePage(userID); //Pass userID to use in WelcomePage
                } else {
                    this.messageLabel.setForeground(Color.red);
                    this.messageLabel.setText("Wrong password!");
                }
            } else {
                this.messageLabel.setForeground(Color.red);
                this.messageLabel.setText("Username not found!");
            }
        }

        if (e.getSource() == this.signupButton) {
            this.frame.dispose();
            new SignupPage(this.idandPasswords.getLoginInfo());
            //Need to pass ID and Passowrd info to signup page
        }

    }
}
