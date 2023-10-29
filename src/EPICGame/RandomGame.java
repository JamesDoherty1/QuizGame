package EPICGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class RandomGame implements ActionListener{

    String[] questions = 	{
            "What is 1+1?",
            "Immersive _______ Engineering?",
            "Where is UL?",
            "What is 10 x 0?"
    };
    String[][] options = 	{
            {"2","4","-2","1"},
            {"Chemical","Software","Mechanical","Aeronautical"},
            {"Galway","Dublin","Limerick","Clare"},
            {"10","1","100","0"}
    };
    char[] answers = 		{
            'A',
            'B',
            'C',
            'C'
    };
    char guess;
    char answer;
    int index;
    int correct_guesses =0;
    int total_questions = questions.length;
    int result;

    JFrame frame = new JFrame();
    JTextField textfield = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton returnButton = new JButton();
    JLabel answer_labelA = new JLabel();
    JLabel answer_labelB = new JLabel();
    JLabel answer_labelC = new JLabel();
    JLabel answer_labelD = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    ImageIcon backgroundImage = new ImageIcon ("images/RandomGameBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    public RandomGame() {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(460,0,650,50);
        textfield.setBackground(new Color(0,255,255));
        textfield.setForeground(new Color(0,0,0));
        textfield.setFont(new Font("Orbitron",Font.BOLD,30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(460,50,650,50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25,25,25));
        textarea.setForeground(new Color(0,255,255));
        textarea.setFont(new Font("Orbitron",Font.BOLD,25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(460,150,100,100);
        buttonA.setFont(new Font("Orbitron",Font.BOLD,35));
        buttonA.setBackground(new Color(0,255,255));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(460,250,100,100);
        buttonB.setFont(new Font("Orbitron",Font.BOLD,35));
        buttonB.setBackground(new Color(0,255,255));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(460,350,100,100);
        buttonC.setFont(new Font("Orbitron",Font.BOLD,35));
        buttonC.setBackground(new Color(0,255,255));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(460,450,100,100);
        buttonD.setFont(new Font("Orbitron",Font.BOLD,35));
        buttonD.setBackground(new Color(0,255,255));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        returnButton.setBounds(625,650,300,80);
        returnButton.setFont(new Font("Orbitron",Font.BOLD,35));
        returnButton.setBackground(new Color(0,255,255));
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setText("Give Up");

        answer_labelA.setBounds(585,150,500,100);
        answer_labelA.setBackground(new Color(50,50,50));
        answer_labelA.setForeground(new Color(25,255,0));
        answer_labelA.setFont(new Font("Black Ops One",Font.PLAIN,35));

        answer_labelB.setBounds(585,250,500,100);
        answer_labelB.setBackground(new Color(50,50,50));
        answer_labelB.setForeground(new Color(25,255,0));
        answer_labelB.setFont(new Font("Black Ops One",Font.PLAIN,35));

        answer_labelC.setBounds(585,350,500,100);
        answer_labelC.setBackground(new Color(50,50,50));
        answer_labelC.setForeground(new Color(25,255,0));
        answer_labelC.setFont(new Font("Black Ops One",Font.PLAIN,35));

        answer_labelD.setBounds(585,450,500,100);
        answer_labelD.setBackground(new Color(50,50,50));
        answer_labelD.setForeground(new Color(25,255,0));
        answer_labelD.setFont(new Font("Black Ops One",Font.PLAIN,35));

        number_right.setBounds(675,225,200,100);
        number_right.setBackground(new Color(25,25,25));
        number_right.setForeground(new Color(25,255,0));
        number_right.setFont(new Font("Orbitron",Font.BOLD,50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(675,325,200,100);
        percentage.setBackground(new Color(25,25,25));
        percentage.setForeground(new Color(25,255,0));
        percentage.setFont(new Font("Orbitron",Font.BOLD,50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        frame.add(answer_labelA);
        frame.add(answer_labelB);
        frame.add(answer_labelC);
        frame.add(answer_labelD);
        frame.add(buttonA);
        frame.add(buttonB);
        frame.add(buttonC);
        frame.add(buttonD);
        frame.add(textarea);
        frame.add(textfield);
        frame.add(returnButton);
        frame.setVisible(true);

        nextQuestion();
    }
    public void nextQuestion() {

        if(index>=total_questions) {
            results();
        }
        else {
            textfield.setText("Question "+(index+1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(e.getSource()==buttonA) {
            answer= 'A';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonB) {
            answer= 'B';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonC) {
            answer= 'C';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==buttonD) {
            answer= 'D';
            if(answer == answers[index]) {
                correct_guesses++;
            }
        }
        if(e.getSource()==returnButton) {
            frame.dispose();
            new WelcomePage("again");
        }
        displayAnswer();
    }
    public void displayAnswer() {


        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if(answers[index] != 'A')
            answer_labelA.setForeground(new Color(255,0,0));
        if(answers[index] != 'B')
            answer_labelB.setForeground(new Color(255,0,0));
        if(answers[index] != 'C')
            answer_labelC.setForeground(new Color(255,0,0));
        if(answers[index] != 'D')
            answer_labelD.setForeground(new Color(255,0,0));

        Timer pause = new Timer(2000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                answer_labelA.setForeground(new Color(25,255,0));
                answer_labelB.setForeground(new Color(25,255,0));
                answer_labelC.setForeground(new Color(25,255,0));
                answer_labelD.setForeground(new Color(25,255,0));

                answer = ' ';
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }
    public void results(){

        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        result = (int)((correct_guesses/(double)total_questions)*100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("("+correct_guesses+"/"+total_questions+")");
        percentage.setText(result+"%");

        returnButton.setText("Return Home");
        frame.add(number_right);
        frame.add(percentage);

    }
}