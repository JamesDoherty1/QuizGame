package EPICGame;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class DifficultyLevels{
    JFrame frame = new JFrame();
    JButton returnButton = new JButton("Return");
    JButton hardButton = new JButton("Hard");
    JButton mediumButton = new JButton("Medium");
    JButton easyButton = new JButton("Easy");

    DifficultyLevels(String subject) {

        this.returnButton.setBounds(750, 600, 100, 25);
        this.returnButton.setFocusable(false);

        this.hardButton.setBounds(650, 500, 300, 40);
        this.hardButton.setFocusable(false);

        this.mediumButton.setBounds(650, 350, 300, 40);
        this.mediumButton.setFocusable(false);

        this.easyButton.setBounds(650, 200, 300, 40);
        this.easyButton.setFocusable(false);

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


