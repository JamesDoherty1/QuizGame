package EPICGame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class ComputerOrganization implements ActionListener {

    // Array to store questions
    String[] questions = {
            "What is 1+1?",
            "Immersive _______ Engineering?",
            "Where is UL?",
            "What is 10 x 0?"
    };

    // 2D array to store answer options
    String[][] options = {
            {"2", "4", "-2", "1"},
            {"Chemical", "Software", "Mechanical", "Aeronautical"},
            {"Galway", "Dublin", "Limerick", "Clare"},
            {"10", "1", "100", "0"}
    };

    // Array to store correct answers
    char[] answers = {
            'A',
            'B',
            'C',
            'C'
    };

    // Variables to track game state
    char guess;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions = questions.length;
    int result;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Calculate the positions relative to the screen center
    int centerX = screenSize.width / 2;
    int centerY = screenSize.height / 2;
    int buttonWidth = 100;
    int buttonHeight = 100;

    // GUI components
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
    ImageIcon backgroundImage = new ImageIcon("images/ComputerOrganizationBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    public ComputerOrganization(String Difficulty, String subject) {
        // Set the background image
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield.setBounds(centerX - 325, centerY - 375, 650, 50);
        textfield.setBackground(new Color(0, 255, 255));
        textfield.setForeground(new Color(0, 0, 0));
        textfield.setFont(new Font("Orbitron", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(centerX - 325, centerY - 325, 650, 100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(0, 255, 255));
        textarea.setFont(new Font("Orbitron", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(centerX - 325, centerY - 175, buttonWidth, buttonHeight);
        buttonA.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonA.setBackground(new Color(0, 255, 255));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(centerX - 325, centerY - 75, buttonWidth, buttonHeight);
        buttonB.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonB.setBackground(new Color(0, 255, 255));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(centerX - 325, centerY + 25, buttonWidth, buttonHeight);
        buttonC.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonC.setBackground(new Color(0, 255, 255));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(centerX - 325, centerY + 125, buttonWidth, buttonHeight);
        buttonD.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonD.setBackground(new Color(0, 255, 255));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        returnButton.setBounds(centerX - 150, centerY + 275, 300, 80);
        returnButton.setFont(new Font("Orbitron", Font.BOLD, 35));
        returnButton.setBackground(new Color(0, 255, 255));
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setText("Give Up");

        answer_labelA.setBounds(centerX - 215, centerY - 175, 500, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        answer_labelB.setBounds(centerX - 215, centerY - 75, 500, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        answer_labelC.setBounds(centerX - 215, centerY + 25, 500, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        answer_labelD.setBounds(centerX - 215, centerY + 125, 500, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("Black Ops One", Font.PLAIN, 35));

        number_right.setBounds(centerX + 35, centerY - 50, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Orbitron", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(centerX + 35, centerY + 50, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Orbitron", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        // Add GUI components to the frame
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

        // Load the first question
        nextQuestion();
    }

    // Method to load the next question
    public void nextQuestion() {
        if (index >= total_questions) {
            // If all questions are answered, show the results
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
        // Disable answer buttons once an answer is selected
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
            // If "Give Up" button is clicked, return to Welcome Page
            frame.dispose();
            new WelcomePage("again");
        }

        // Display the correct answer and move to the next question
        displayAnswer();
    }

    // Method to display the correct answer
    public void displayAnswer() {
        // Disable answer buttons
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        // Highlight the correct answer
        if (answers[index] != 'A')
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'B')
            answer_labelB.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'C')
            answer_labelC.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'D')
            answer_labelD.setForeground(new Color(255, 0, 0));

        // Set a pause before moving to the next question
        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Reset answer labels and other settings
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

    // Method to display the game results
    public void results() {
        // Disable answer buttons
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        // Hide answer buttons
        buttonA.setVisible(false);
        buttonB.setVisible(false);
        buttonC.setVisible(false);
        buttonD.setVisible(false);

        // Calculate the player's score
        result = (int) ((correct_guesses / (double) total_questions) * 100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        answer_labelA.setText("");
        answer_labelB.setText("");
        answer_labelC.setText("");
        answer_labelD.setText("");

        number_right.setBounds(centerX - 225, centerY - 75, 500, 100); // Adjust the position
        number_right.setText("Correct: " + correct_guesses + "/" + total_questions);
        number_right.setEditable(false);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Orbitron", Font.BOLD, 50));

        percentage.setBounds(centerX - 225, centerY + 25, 500, 100); // Adjust the position
        percentage.setText("Percentage: " + result + "%");
        percentage.setEditable(false);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Orbitron", Font.BOLD, 50));

        returnButton.setText("Return Home");
        frame.add(number_right);
        frame.add(percentage);
    }
}