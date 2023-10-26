package EPICGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComputerScience implements ActionListener {

    // Define arrays for quiz questions, answer choices, and correct answers
    String[] questions = {
            "What is 1+1?",
            "Immersive _______ Engineering?",
            "Where is UL?",
            "What is 10 x 0?"
    };
    String[][] options = {
            {"2", "4", "-2", "1"},
            {"Chemical", "Software", "Mechanical", "Aeronautical"},
            {"Galway", "Dublin", "Limerick", "Clare"},
            {"10", "1", "100", "0"}
    };
    char[] answers = {
            'A',
            'B',
            'C',
            'C'
    };

    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;

    // Create GUI components for the quiz game
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

    // Load the background image
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\jkdoh\\IdeaProjects\\EPICEndeavourGame\\src\\EPICGame\\ComputerScienceBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    // Constructor for the ComputerScience class
    public ComputerScience(String Difficulty, String subject) {
        // Set up the GUI layout and initial properties
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(false);

        // Configure and position GUI elements
        textfield.setBounds(460, 0, 650, 50);
        textfield.setBackground(new Color(0, 255, 255));
        textfield.setForeground(new Color(0, 0, 0));
        textfield.setFont(new Font("Orbitron", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(460, 50, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(0, 255, 255));
        textarea.setFont(new Font("Orbitron", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        // Set up answer choice buttons (A, B, C, D)
        buttonA.setBounds(460, 150, 100, 100);
        buttonA.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonA.setBackground(new Color(0, 255, 255));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(460, 250, 100, 100);
        buttonB.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonB.setBackground(new Color(0, 255, 255));
        buttonB.setFocusable (false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(460, 350, 100, 100);
        buttonC.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonC.setBackground(new Color(0, 255, 255));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(460, 450, 100, 100);
        buttonD.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonD.setBackground(new Color(0, 255, 255));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        returnButton.setBounds(625, 650, 300, 80);
        returnButton.setFont(new Font("Orbitron", Font.BOLD, 35));
        returnButton.setBackground(new Color(0, 255, 255));
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setText("Give Up");

        // Set up answer choice labels (A, B, C, D)
        answer_labelA.setBounds(585, 150, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        answer_labelB.setBounds(585, 250, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        answer_labelC.setBounds(585, 350, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        answer_labelD.setBounds(585, 450, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        // Set up text fields for displaying results
        number_right.setBounds(675, 225, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Orbitron", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(675, 325, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Orbitron", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        // Add GUI components to the frame and make it visible
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

        // Start the quiz by displaying the first question
        nextQuestion();
    }

    // Method to display the next question
    public void nextQuestion() {
        if (index >= total_questions) {
            // If all questions have been answered, show the results
            results();
        } else {
            // Display the current question and answer choices
            textfield.setText("Question " + (index + 1));
            textarea.setText(questions[index]);
            answer_labelA.setText(options[index][0]);
            answer_labelB.setText(options[index][1]);
            answer_labelC.setText(options[index][2]);
            answer_labelD.setText(options[index][3]);
        }
    }

    // ActionListener implementation to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Disable answer buttons while processing user input
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (e.getSource() == buttonA) {
            answer = 'A';
            if (answer == answers[index]) {
                // Check if the user's answer is correct and update the score
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
            // If the "Give Up" button is clicked, return to the welcome page
            frame.dispose();
            new WelcomePage("again");
        }
        // Display the correct answer and move to the next question
        displayAnswer();
    }

    // Method to display the correct answer
    public void displayAnswer() {
        // Disable answer buttons temporarily and highlight correct answer
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'A') answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B') answer_labelB.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'C') answer_labelC.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'D') answer_labelD.setForeground(new Color(255, 0, 0));

        // Create a timer to reset the interface and move to the next question
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset answer highlights, clear user's answer, and enable buttons
                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));
                answer = ' ';
                buttonA.setEnabled(true);
                buttonB.setEnabled(true);
                buttonC.setEnabled(true);
                buttonD.setEnabled(true);
                // Move to the next question
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    // Method to display the final quiz results
    public void results() {
        // Disable answer buttons and hide them
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        // Calculate and display the user's score
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