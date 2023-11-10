package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class TimerGame implements ActionListener {

    private String[] questions;
    private String[][] options;
    private char[] answers;
    private char guess;
    private char answer;
    private int index;
    int correct_answers = 0;
    private int total_questions;
    private int result;
    int seconds = 10;

    private char[] userAnswers;

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
    JLabel time_label = new JLabel();
    JLabel seconds_left = new JLabel();
    JTextField number_right = new JTextField();
    JTextField percentage = new JTextField();
    ImageIcon backgroundImage = new ImageIcon("images/TimerGameBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);
    // Get the screen size
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    // Calculate the positions relative to the screen center
    int centerX = screenSize.width / 2;
    int centerY = screenSize.height / 2;
    int buttonWidth = 100;
    int buttonHeight = 100;

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private int[] questionOrder;  // Store the order of questions
    private int currentQuestionIndex;  // Keep track of the current question index

    // Timer for countdown
    Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            seconds_left.setText(String.valueOf(seconds));
            if (seconds <= 0) {
                displayAnswer();
            }
        }
    });
    public TimerGame() {
        // Set the background image
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(false);

        textfield = new JTextField();
        textarea = new JTextArea();
        buttonA = new JButton();
        buttonB = new JButton();
        buttonC = new JButton();
        buttonD = new JButton();
        answer_labelA = new JLabel();
        answer_labelB = new JLabel();
        answer_labelC = new JLabel();
        answer_labelD = new JLabel();
        number_right = new JTextField();
        percentage = new JTextField();

        // Initialize the database connection
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:EpicDatabase.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Load questions and answers from the database
        loadQuestionsFromDatabase();

        total_questions = questions.length;

        // Setting Up Buttons and Labels
        textfield.setBounds(centerX - 325, centerY - 375, 650, 50);
        textfield.setBackground(new Color(0, 255, 255));
        textfield.setForeground(new Color(0, 0, 0));
        textfield.setFont(new Font("Orbitron", Font.BOLD, 22));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea.setBounds(centerX - 325, centerY - 325, 650, 100);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(0, 255, 255));
        textarea.setFont(new Font("Orbitron", Font.BOLD, 22));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        buttonA.setBounds(centerX - 525, centerY - 175, buttonWidth, buttonHeight);
        buttonA.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonA.setBackground(new Color(0, 255, 255));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(centerX - 525, centerY - 75, buttonWidth, buttonHeight);
        buttonB.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonB.setBackground(new Color(0, 255, 255));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(centerX - 525, centerY + 25, buttonWidth, buttonHeight);
        buttonC.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonC.setBackground(new Color(0, 255, 255));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(centerX - 525, centerY + 125, buttonWidth, buttonHeight);
        buttonD.setFont(new Font("Orbitron", Font.BOLD, 35));
        buttonD.setBackground(new Color(0, 255, 255));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        returnButton = new JButton();
        returnButton.setBounds(centerX - 150, centerY + 275, 300, 80);
        returnButton.setFont(new Font("Orbitron", Font.BOLD, 22));
        returnButton.setBackground(new Color(0, 255, 255));
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);
        returnButton.setText("Give Up");
        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == returnButton) {
                    frame.dispose();
                    String username = null;
                    new WelcomePage(username); // Assuming you need to pass the username
                }
            }
        });

        answer_labelA.setBounds(centerX - 415, centerY - 175, 1000, 100);
        answer_labelA.setBackground(new Color(50, 50, 50));
        answer_labelA.setForeground(new Color(25, 255, 0));
        answer_labelA.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        answer_labelB.setBounds(centerX - 415, centerY - 75, 1000, 100);
        answer_labelB.setBackground(new Color(50, 50, 50));
        answer_labelB.setForeground(new Color(25, 255, 0));
        answer_labelB.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        answer_labelC.setBounds(centerX - 415, centerY + 25, 1000, 100);
        answer_labelC.setBackground(new Color(50, 50, 50));
        answer_labelC.setForeground(new Color(25, 255, 0));
        answer_labelC.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        answer_labelD.setBounds(centerX - 415, centerY + 125, 1000, 100);
        answer_labelD.setBackground(new Color(50, 50, 50));
        answer_labelD.setForeground(new Color(25, 255, 0));
        answer_labelD.setFont(new Font("Black Ops One", Font.PLAIN, 20));

        seconds_left.setBounds(centerX + 670, centerY + 310, 100, 100);
        seconds_left.setBackground(new Color(0, 255, 255));
        seconds_left.setForeground(new Color(255, 0, 0));
        seconds_left.setFont(new Font("Black Ops One", Font.BOLD, 60));
        seconds_left.setBorder(BorderFactory.createBevelBorder(1));
        seconds_left.setOpaque(true);
        seconds_left.setHorizontalAlignment(JTextField.CENTER);
        seconds_left.setText(String.valueOf(seconds));

        number_right.setBounds(centerX - 100, centerY - 100, 200, 100);
        number_right.setBackground(new Color(25, 25, 25));
        number_right.setForeground(new Color(25, 255, 0));
        number_right.setFont(new Font("Orbitron", Font.BOLD, 50));
        number_right.setBorder(BorderFactory.createBevelBorder(1));
        number_right.setHorizontalAlignment(JTextField.CENTER);
        number_right.setEditable(false);

        percentage.setBounds(centerX - 100, centerY, 200, 100);
        percentage.setBackground(new Color(25, 25, 25));
        percentage.setForeground(new Color(25, 255, 0));
        percentage.setFont(new Font("Orbitron", Font.BOLD, 50));
        percentage.setBorder(BorderFactory.createBevelBorder(1));
        percentage.setHorizontalAlignment(JTextField.CENTER);
        percentage.setEditable(false);

        // Add GUI components to the frame
        frame.add(time_label);
        frame.add(seconds_left);
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


    questionOrder = new int[total_questions];
        for (int i = 0; i < total_questions; i++) {
            questionOrder[i] = i;
        }


        nextQuestion();
    }


    private void loadQuestionsFromDatabase() {
        questions = new String[18];
        options = new String[18][4];
        answers = new char[18];
        try {
            String query = "SELECT question, choice1, choice2, choice3, choice4, correct_answer FROM quiz_questions";
            statement = connection.prepareStatement(query);
            resultSet = statement.executeQuery();

            int questionCount = 0;
            while (resultSet.next() && questionCount <= 18) {
                questions[questionCount] = resultSet.getString("question");
                options[questionCount][0] = resultSet.getString("choice1");
                options[questionCount][1] = resultSet.getString("choice2");
                options[questionCount][2] = resultSet.getString("choice3");
                options[questionCount][3] = resultSet.getString("choice4");
                answers[questionCount] = resultSet.getString("correct_answer").charAt(1);

                questionCount++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void nextQuestion() {
        if (currentQuestionIndex >= total_questions) {
            results();
        } else {
            int currentQuestionID = questionOrder[currentQuestionIndex];
            textfield.setText("Question " + (currentQuestionIndex + 1));
            textarea.setText(questions[currentQuestionID]);

            // Set the answer labels
            answer_labelA.setText(options[currentQuestionID][0]);
            answer_labelB.setText(options[currentQuestionID][1]);
            answer_labelC.setText(options[currentQuestionID][2]);
            answer_labelD.setText(options[currentQuestionID][3]);

            currentQuestionIndex++;
            timer.start();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (index < answers.length) {

            JButton selectedButton = (JButton) e.getSource();
            char buttonText = selectedButton.getText().charAt(0);

            // System.out.println(buttonText + " and correct ans: " + Character.toUpperCase((answers[index]))); Debugging check

            if (buttonText == Character.toUpperCase((answers[index]))) {
                correct_answers++;
                //  System.out.println("incremented");    Debugging
            }


            if (currentQuestionIndex > total_questions) {
                results();
            } else {
                displayAnswer();
            }
        }
    }


    public void displayAnswer() {

        timer.stop();
        buttonA.setEnabled(false);
        buttonB.setEnabled(false);
        buttonC.setEnabled(false);
        buttonD.setEnabled(false);

        if (answers[index] != 'a')
            answer_labelA.setForeground(new Color(255, 0, 0));
        if (answers[index] != 'b')
            answer_labelB.setForeground(new Color(255, 0, 0));

        if (answers[index] != 'c')
            answer_labelC.setForeground(new Color(255, 0, 0));

        if (answers[index] != 'd')
            answer_labelD.setForeground(new Color(255, 0, 0));
        //The answer label is set to red if the answer is incorrect

        Timer pause = new Timer(1000, new ActionListener() {    //Sets 2 second timer
            @Override
            public void actionPerformed(ActionEvent e) {
                answer_labelA.setForeground(new Color(25, 255, 0));
                answer_labelB.setForeground(new Color(25, 255, 0));
                answer_labelC.setForeground(new Color(25, 255, 0));
                answer_labelD.setForeground(new Color(25, 255, 0));

                answer = ' ';
                seconds = 10;
                seconds_left.setText(String.valueOf(seconds));
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


    private void results() {
        result = (int) ((correct_answers / (double) total_questions) * 100);
        textfield.setText("Result!");
        textarea.setText("");
        answer_labelA.setText(" ");
        answer_labelB.setText(" ");
        answer_labelC.setText(" ");
        answer_labelD.setText(" ");
        number_right.setText("[" + correct_answers + "/" + total_questions + "]");
        percentage.setText(result + "%");
        frame.add(percentage);
        frame.add(number_right);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TimerGame());
    }
}