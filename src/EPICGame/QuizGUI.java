package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizGUI implements ActionListener {

    private JFrame frame;
    private JTextField textfield;
    private JTextArea textarea;
    private JButton[] optionButtons;
    private JLabel[] answerLabels;
    private int index = 0;
    private int correctGuesses = 0;
    private int totalQuestions;
    private char[] answers;
    private String[] questions;
    private String[][] options;

    public QuizGUI(String[] questions, String[][] options, char[] answers) {
        this.questions = questions;
        this.options = options;
        this.answers = answers;
        this.totalQuestions = questions.length;

        frame = new JFrame("Multiple Choice Quiz");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(460, 0, 650, 50);
        textfield.setBackground(new Color(0, 255, 255));
        textfield.setForeground(new Color(0, 0, 0));
        textfield.setFont(new Font("Orbitron", Font.BOLD, 30));
        textfield.setBorder(BorderFactory.createBevelBorder(1));
        textfield.setHorizontalAlignment(JTextField.CENTER);
        textfield.setEditable(false);

        textarea = new JTextArea();
        textarea.setBounds(460, 50, 650, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(new Color(25, 25, 25));
        textarea.setForeground(new Color(0, 255, 255));
        textarea.setFont(new Font("Orbitron", Font.BOLD, 25));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        optionButtons = new JButton[4];
        answerLabels = new JLabel[4];

        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JButton();
            optionButtons[i].setBounds(460, 150 + i * 100, 100, 100);
            optionButtons[i].setFont(new Font("Orbitron", Font.BOLD, 35));
            optionButtons[i].setBackground(new Color(0, 255, 255));
            optionButtons[i].setFocusable(false);
            optionButtons[i].addActionListener(this);
            optionButtons[i].setText(Character.toString((char) ('A' + i)));

            answerLabels[i] = new JLabel();
            answerLabels[i].setBounds(585, 150 + i * 100, 500, 100);
            answerLabels[i].setBackground(new Color(50, 50, 50));
            answerLabels[i].setForeground(new Color(25, 255, 0));
            answerLabels[i].setFont(new Font("Black Ops One", Font.PLAIN, 35));

            frame.add(optionButtons[i]);
            frame.add(answerLabels[i]);
        }

        frame.add(textfield);
        frame.add(textarea);
        frame.setVisible(true);

        nextQuestion();
    }

    public void nextQuestion() {
        if (index >= totalQuestions) {
            results();
        } else {
            textfield.setText("Question " + (index + 1));
            textarea.setText(questions[index]);

            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(Character.toString((char) ('A' + i)));
                answerLabels[i].setText(options[index][i]);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setEnabled(false);
            if (e.getSource() == optionButtons[i]) {
                if (answers[index] == (char) ('A' + i)) {
                    correctGuesses++;
                }
            }
        }
        displayAnswer();
    }

    public void displayAnswer() {
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setEnabled(false);
            if (answers[index] != (char) ('A' + i)) {
                answerLabels[i].setForeground(new Color(255, 0, 0));
            }
        }

        Timer pause = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < 4; i++) {
                    answerLabels[i].setForeground(new Color(25, 255, 0));
                }
                for (int i = 0; i < 4; i++) {
                    optionButtons[i].setEnabled(true);
                }
                index++;
                nextQuestion();
            }
        });
        pause.setRepeats(false);
        pause.start();
    }

    public void results() {
        for (int i = 0; i < 4; i++) {
            optionButtons[i].setEnabled(false);
            optionButtons[i].setVisible(false);
        }

        int result = (int) ((correctGuesses / (double) totalQuestions) * 100);

        textfield.setText("RESULTS!");
        textarea.setText("");
        for (int i = 0; i < 4; i++) {
            answerLabels[i].setText("");
        }

        answerLabels[0].setText("(" + correctGuesses + "/" + totalQuestions + ")");
        answerLabels[1].setText(result + "%");
    }
}