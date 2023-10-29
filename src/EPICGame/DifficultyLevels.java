package EPICGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class DifficultyLevels{
    JFrame frame = new JFrame();
    JButton returnButton = new JButton("Return");
    JButton hardButton = new JButton("Hard");
    JButton mediumButton = new JButton("Medium");
    JButton easyButton = new JButton("Easy");
    ImageIcon backgroundImage = new ImageIcon ("images/DifficultyLevelBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    JLabel headerLabel = new JLabel("How Confident Are You?");

    DifficultyLevels(String subject) {
        //Takes in the subject that it came from, so it knows what questions to pick from
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.returnButton.setBounds(700, 700, 200, 70);
        this.returnButton.setFocusable(false);
        this.returnButton.setFont(new Font("Black Ops One",Font.PLAIN,30));
        this.returnButton.setBackground(new Color(0,255,255));

        hardButton.setBounds(650, 500, 300, 80);
        hardButton.setFocusable(false);
        hardButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        hardButton.setBackground(new Color(255,0,0));

        mediumButton.setBounds(650, 350, 300, 80);
        mediumButton.setFocusable(false);
        mediumButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        mediumButton.setBackground(new Color(255,130,0));

        easyButton.setBounds(650, 200, 300, 80);
        easyButton.setFocusable(false);
        easyButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        easyButton.setBackground(new Color(0,255,0));

        headerLabel.setBounds(350, 30, 1200, 100);
        headerLabel.setForeground(new Color(0,255,255));
        headerLabel.setFont(new Font("Black Ops One",Font.BOLD,70));

        this.frame.add(this.returnButton);
        this.frame.add(this.hardButton);
        this.frame.add(this.mediumButton);
        this.frame.add(this.easyButton);
        this.frame.add(this.headerLabel);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager) null);
        this.frame.setVisible(true);

        hardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subject.equals("Discrete Maths")){
                    String Difficulty = "Hard";
                    new DiscreteMaths(Difficulty, subject);
                }
                if(subject.equals("Computer Organization")){
                    String Difficulty = "Hard";
                    new ComputerOrganization(Difficulty, subject);
                }
                if(subject.equals("Computer Science")){
                    String Difficulty = "Hard";
                    new ComputerScience(Difficulty, subject);
                }
            }
            //It passes the subject it came from and difficulty as a String
        });
        mediumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subject.equals("Discrete Maths")){
                    String Difficulty = "Medium";
                    new DiscreteMaths(Difficulty, subject);
                }
                if(subject.equals("Computer Organization")){
                    String Difficulty = "Medium";
                    new ComputerOrganization(Difficulty, subject);
                }
                if(subject.equals("Computer Science")){
                    String Difficulty = "Medium";
                    new ComputerScience(Difficulty, subject);
                }
            }
            //It passes the subject it came from and difficulty as a String
        });
        easyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subject.equals("Discrete Maths")){
                    String Difficulty = "Easy";
                    new DiscreteMaths(Difficulty, subject);
                }
                if(subject.equals("Computer Organization")){
                    String Difficulty = "Easy";
                    new ComputerOrganization(Difficulty, subject);
                }
                if(subject.equals("Computer Science")){
                    String Difficulty = "Easy";
                    new ComputerScience(Difficulty, subject);
                }
            }
            //It passes the subject it came from and difficulty as a String
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == returnButton){
                    new WelcomePage("again");
                    //Send again as the String to WelcomePage constructor when it opens
                }
            }
        });
    }}


