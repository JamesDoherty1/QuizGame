package EPICGame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComputerOrganization implements ActionListener {
    String[] questions;
    String[][] options;

    String[] easyQuestions = {
            "What is the purpose of the CPU in a computer system, and what are its primary components?",
            "Explain the concept of memory hierarchy in computer organization and the role of cache memory."
    };

    String[] mediumQuestions = {
            "Describe the von Neumann architecture and its key components. How does it differ from Harvard architecture?",
            "Discuss the role of the Memory Management Unit (MMU) in a computer system and how it facilitates virtual memory."
    };

    String[] hardQuestions = {
            "Explain the concept of pipelining in CPU design. Discuss the advantages and challenges associated with pipelined processors.",
            "Describe the differences between RISC (Reduced Instruction Set Computer) and CISC (Complex Instruction Set Computer) architectures. What are the advantages and disadvantages of each?"
    };

    String[][] easyQuestionOptions = {
            {"The CPU is responsible for long-term storage of data, and its primary components are the motherboard, RAM, and hard drive.", "The CPU performs arithmetic and logical operations, and its primary components are the control unit, ALU, and registers.", "The CPU manages input and output devices, and its primary components include the control unit, ALU, and registers.", "The CPU is responsible for displaying graphics on the monitor, and its primary components are the keyboard, mouse, and GPU."},
            {"Memory hierarchy is the order of different types of memory in terms of access speed, and cache memory provides high-speed storage for frequently accessed data.", "Memory hierarchy refers to organizing data alphabetically in a computer, and cache memory stores frequently used software applications.", "Memory hierarchy involves arranging memory modules by size, and cache memory is used for permanent data storage.", "Memory hierarchy refers to arranging data by importance, and cache memory is used for temporary storage of files."}
    };

    String[][] mediumQuestionOptions = {
            {"Von Neumann architecture has a single memory for both data and instructions, while Harvard architecture has separate memory units for data and instructions.", "Von Neumann architecture separates data and instructions, while Harvard architecture combines them in the same memory.", "Von Neumann architecture uses multiple CPUs for parallel processing, while Harvard architecture uses a single CPU.", "Von Neumann architecture utilizes a unique data compression algorithm, while Harvard architecture relies on file compression."},
            {"The MMU is responsible for managing network connections in a computer, and it has no role in virtual memory.", "The MMU is part of the Central Processing Unit (CPU), and it facilitates virtual reality experiences.", "The MMU is involved in graphics rendering, and it improves the visual quality of computer games.", "The MMU translates virtual addresses to physical addresses and helps in the efficient use of physical memory for virtual memory systems."}
    };

    String[][] hardQuestionOptions = {
            {"Pipelining is a technique to transport oil through CPU components, and it reduces energy consumption.", "Pipelining involves arranging CPUs in a pipeline for faster data transfer and has no advantages or challenges.", "Pipelining divides the CPU execution into stages, allowing for parallel processing, but it can introduce hazards like data hazards and control hazards.", "Pipelining increases the clock speed of the CPU, resulting in improved battery life in mobile devices."},
            {"RISC architectures typically have a simpler and smaller instruction set, while CISC architectures have more complex and diverse instructions.", "RISC and CISC architectures are identical, and there are no differences between them.", "RISC architectures have a large and complex instruction set, while CISC architectures have a reduced instruction set.", "RISC architectures are older and less efficient, while CISC architectures are more modern and faster."}
    };

    char[] easyAnswers = {
            'B',
            'A'
    };

    char[] mediumAnswers = {
            'A',
            'D'
    };

    char[] hardAnswers = {
            'C',
            'A'
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
    ImageIcon backgroundImage = new ImageIcon("background.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    public ComputerOrganization(String Difficulty, String subject) {
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
        buttonA.setBounds(centerX - 325, centerY - 175, 100, 100);
        buttonB.setBounds(centerX - 325, centerY - 75, 100, 100);
        buttonC.setBounds(centerX - 325, centerY + 25, 100, 100);
        buttonD.setBounds(centerX - 325, centerY + 125, 100, 100);
        returnButton.setBounds(centerX - 150, centerY + 275, 300, 80);
        answer_labelA.setBounds(centerX - 215, centerY - 175, 500, 100);
        answer_labelB.setBounds(centerX - 215, centerY - 75, 500, 100);
        answer_labelC.setBounds(centerX - 215, centerY + 25, 500, 100);
        answer_labelD.setBounds(centerX - 215, centerY + 125, 500, 100);
        number_right.setBounds(centerX - 100, centerY - 100, 200, 100);
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
        answer_labelA.setFont(new Font("Black Ops One", Font.PLAIN, 35));
        answer_labelB.setFont(new Font("Black Ops One", Font.PLAIN, 35));
        answer_labelC.setFont(new Font("Black Ops One", Font.PLAIN, 35));
        answer_labelD.setFont(new Font("Black Ops One", Font.PLAIN, 35));
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
