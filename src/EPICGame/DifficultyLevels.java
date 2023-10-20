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
    ImageIcon backgroundImage = new ImageIcon ("C:\\Users\\jkdoh\\IdeaProjects\\EPICEndeavourGame\\src\\EPICGame\\DifficultyLevelBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    DifficultyLevels(String subject) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        this.returnButton.setBounds(700, 650, 200, 70);
        this.returnButton.setFocusable(false);
        this.returnButton.setFont(new Font("Black Ops One",Font.PLAIN,30));
        this.returnButton.setBackground(new Color(0,255,255));

        this.hardButton.setBounds(650, 400, 300, 80);
        this.hardButton.setFocusable(false);
        this.hardButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        this.hardButton.setBackground(new Color(255,0,0));

        this.mediumButton.setBounds(650, 250, 300, 80);
        this.mediumButton.setFocusable(false);
        this.mediumButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        this.mediumButton.setBackground(new Color(255,130,0));

        this.easyButton.setBounds(650, 100, 300, 80);
        this.easyButton.setFocusable(false);
        this.easyButton.setFont(new Font("Black Ops One",Font.PLAIN,40));
        this.easyButton.setBackground(new Color(0,255,0));

        this.frame.add(this.returnButton);
        this.frame.add(this.hardButton);
        this.frame.add(this.mediumButton);
        this.frame.add(this.easyButton);
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
        });
        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == returnButton){
                    new WelcomePage("again");
                }
            }
        });
    }}


