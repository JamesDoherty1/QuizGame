package EPICGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComputerScience implements ActionListener {
    String[] questions;
    String[][] options;

    String[] easyQuestions = {
            "What does BNF stand for in computer science?",
            "In programming, what is the purpose of syntax?"
    };

    String[] mediumQuestions = {
            "In the context of ordered structures, what does a lattice represent?",
            "Which of the following best describes the concept of a 'partial order' in ordered structures and lattices?"
    };

    String[] hardQuestions = {
            "What is a Binary Decision Diagram (BDD) primarily used for in computer science and digital circuit design?",
            "When considering Binary Decision Diagrams, what is the significance of 'reduction' or 'minimization'?"
    };

    String[][] easyQuestionOptions = {
            {"Basic Numerical Format", "Backus-Naur Form", "Binary Notation Framework", "Basic Networking Function"},
            {"To define the meaning of variables", "To specify the order of execution of instructions", "To describe the structure and rules for constructing valid programs", "To control the flow of program execution"}
    };

    String[][] mediumQuestionOptions = {
            {"A data structure for organizing files in a computer", "A mathematical structure that describes a set with both a meet (infimum) and a join (supremum) operation", "A diagram used to visualize software architecture", "A scheduling algorithm used in operating systems"},
            {"A data structure that allows elements to be inserted and removed in any order", "A mathematical relation that is reflexive, antisymmetric, and transitive, defining a partial ordering on a set of elements", "A data structure for quick retrieval of elements in constant time", "A mathematical concept used to perform sorting operations on arrays"}
    };

    String[][] hardQuestionOptions = {
            {"Representing arithmetic calculations in a compact form", "Modeling complex control flow in software programs", "Efficiently representing and manipulating Boolean functions", "Storing and retrieving binary data in a database"},
            {"A process of converting binary numbers to their hexadecimal equivalents", "The procedure of converting multi-level logic circuits to two-level representations", "A technique for increasing the depth and complexity of the BDD to handle larger functions", "The operation of transforming a BDD to its simplest and most compact form while preserving its functionality"}
    };

    char[] easyAnswers = {
            'B',
            'C'
    };

    char[] mediumAnswers = {
            'B',
            'B'
    };

    char[] hardAnswers = {
            'C',
            'D'
    };

    char[] answers;

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions;
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
    ImageIcon backgroundImage = new ImageIcon("images/ComputerScienceBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    public ComputerScience(String Difficulty, String subject) {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        total_questions = easyQuestions.length + mediumQuestions.length + hardQuestions.length;
        answers = new char[total_questions];

        if (Difficulty.equals("Easy")) {
            questions = easyQuestions;
            options = easyQuestionOptions;
            answers = easyAnswers;
        } else if (Difficulty.equals("Medium")) {
            questions = mediumQuestions;
            options = mediumQuestionOptions;
            answers = mediumAnswers;
        } else if (Difficulty.equals("Hard")) {
            questions = hardQuestions;
            options = hardQuestionOptions;
            answers = hardAnswers;
        }

        textfield.setBounds(centerX - 325, centerY - 375, 650, 50);
        textarea.setBounds(centerX - 325, centerY - 325, 650, 100);
        buttonA.setBounds(centerX - 525, centerY - 175, 100, 100);
        buttonB.setBounds(centerX - 525, centerY - 75, 100, 100);
        buttonC.setBounds(centerX - 525, centerY + 25, 100, 100);
        buttonD.setBounds(centerX - 525, centerY + 125, 100, 100);
        returnButton.setBounds(centerX - 150, centerY + 275, 300, 80);
        answer_labelA.setBounds(centerX - 415, centerY - 175, 1500, 100);
        answer_labelB.setBounds(centerX - 415, centerY - 75, 1500, 100);
        answer_labelC.setBounds(centerX - 415, centerY + 25, 1500, 100);
        answer_labelD.setBounds(centerX - 415, centerY + 125, 1500, 100);
        number_right.setBounds(centerX - 100, centerY - 100, 500, 100);
        percentage.setBounds(centerX - 100, centerY, 200, 100);

        textfield.setBackground(new Color(0, 255, 255));
        textarea.setBackground(new Color(25, 25, 25));
        buttonA.setBackground(new Color(0, 255, 255));
        buttonB.setBackground(new Color(0, 255, 255));
        buttonC.setBackground(new Color(0, 255, 255));
        buttonD.setBackground(new Color(0, 255, 255));
        returnButton.setBackground(new Color(0, 255, 255));
        number_right.setBackground(new Color(25, 25, 25));
        percentage.setBackground(new Color(25, 25, 25));

        textfield.setFont(new Font("Orbitron", Font.BOLD, 30));
        textarea.setFont(new Font("Orbitron", Font.BOLD, 25));
        buttonA.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonB.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonC.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonD.setFont(new Font("Orbitron", Font.BOLD, 35));
        returnButton.setFont(new Font("Orbitron", Font.BOLD, 35));
        answer_labelA.setFont(new Font("Black Ops One", Font.PLAIN, 20));
        answer_labelB.setFont(new Font("Black Ops One", Font.PLAIN, 20));
        answer_labelC.setFont(new Font("Black Ops One", Font.PLAIN, 20));
        answer_labelD.setFont(new Font("Black Ops One", Font.PLAIN, 20));
        number_right.setFont(new Font("Orbitron", Font.BOLD, 50));
        percentage.setFont(new Font("Orbitron", Font.BOLD, 50));

        textfield.setForeground(new Color(0, 0, 0));
        textarea.setForeground(new Color(0, 255, 255));
        buttonA.setForeground(new Color(0, 0, 0));
        buttonB.setForeground(new Color(0, 0, 0));
        buttonC.setForeground(new Color(0, 0, 0));
        buttonD.setForeground(new Color(0, 0, 0));
        returnButton.setForeground(new Color(0, 0, 0));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelD.setForeground(new Color(25, 255, 0));
        number_right.setForeground(new Color(25, 255, 0));
        percentage.setForeground(new Color(25, 255, 0));

        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        buttonA.setBorder(BorderFactory.createBevelBorder(1));
        buttonB.setBorder(BorderFactory.createBevelBorder(1));
        buttonC.setBorder(BorderFactory.createBevelBorder(1));
        buttonD.setBorder(BorderFactory.createBevelBorder(1));
        returnButton.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setBorder(BorderFactory.createBevelBorder(1));

        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setEditable(false);

        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setText("Give Up");

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
        if (index >= total_questions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
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

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonB) {
            answer = 'B';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonC) {
            answer = 'C';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == buttonD) {
            answer = 'D';
            if (answer == answers[index]) {
                correct_guesses++;
            }
        }
        if (e.getSource() == returnButton) {
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

        if (answers[index] != 'A')
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B')
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'C')
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'D')
            answer_labelD.setForeground(new Color(255, 0, 0));

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));

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

    public void results() {
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        result = (int) ((correct_guesses / (double) total_questions) * 100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setText("(" + correct_guesses + "/" + total_questions + ")");
        percentage.setText(result + "%");

        returnButton.setText("Return Home");

        frame.add(number_right);
        frame.add(percentage);
    }
}
