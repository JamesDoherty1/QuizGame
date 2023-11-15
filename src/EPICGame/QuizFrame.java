package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizFrame extends JFrame implements ActionListener {
    String Difficulty;
    String subject;
    String[] questions;
    String[][] options;
    char[] answers;
    char answer;
    int index;
    int correct_guesses = 0;
    int total_questions;
    int result;

    private JFrame frame = new JFrame();
    private JTextField textfield = new JTextField();
    private JTextArea textarea = new JTextArea();
    private JButton buttonA = new JButton();
    private JButton buttonB = new JButton();
    private JButton buttonC = new JButton();
    private JButton buttonD = new JButton();
    private JButton returnButton = new JButton();
    private JLabel answer_labelA = new JLabel();
    private JLabel answer_labelB = new JLabel();
    private JLabel answer_labelC = new JLabel();
    private JLabel answer_labelD = new JLabel();
    private JTextField number_right = new JTextField();
    private JTextField percentage = new JTextField();
    private ImageIcon backgroundImage = new ImageIcon("images/Background.jpg");
    private JLabel backgroundLabel = new JLabel(backgroundImage);

    public QuizFrame(String Difficulty, String subject) {
        this.Difficulty = Difficulty;
        this.subject = subject;

        String[] DMeasyQuestions = {
                "Consider the statement: If it is raining, then I will take an umbrella. Which of the following represents the negation of this statement?",
                "If A = {1, 2, 3} and B = {3, 4, 5}, what is the intersection of sets A and B?"
        };

        String[] DMmediumQuestions = {
                "Create a truth table to represent the logical statement: If it is raining, then the ground is wet. Determine if the statement is a tautology, a contradiction, or contingent.",
                "Given the function f: A ? B, where A = {1, 2, 3, 4} and B = {a, b, c, d}, defined as f(1) = b, f(2) = a, f(3) = c, and f(4) = d. Determine if this function is injective, surjective, or bijective. Explain your reasoning."
        };

        String[] DMhardQuestions = {
                "Minimum Spanning Tree: Given a connected, weighted graph G, explain and provide an algorithm to find the minimum spanning tree (MST) of G. Describe the steps involved in the algorithm.",
                "Explain the P vs. NP problem, one of the most famous unsolved questions in computer science. Define P and NP, and discuss the implications of solving this problem."
        };

        String[][] DMeasyQuestionOptions = {
                {"If it is raining, then I will not take an umbrella.", "If it is not raining, then I will take an umbrella.", "If it is not raining, then I will not take an umbrella.", "It is raining and I will take an umbrella."},
                {"{1, 2}", "{3, 4, 5}", "{1, 2, 3, 4, 5}", "{3}"}
        };

        String[][] DMmediumQuestionOptions = {
                {"The statement is a tautology.", "The statement is a contradiction.", "The statement is contingent.", "The statement is neither a tautology nor a contradiction, but it is also not contingent."},
                {"The function is injective.", "The function is surjective.", "The function is bijective.", "The function is neither injective nor surjective, and therefore, not bijective."}
        };

        String[][] DMhardQuestionOptions = {
                {"Kruskal's algorithm: Sort edges by weight, add the lowest-weight edge not causing a cycle.", "Dijkstra's algorithm: Find the shortest path between two arbitrary vertices and repeat until the entire tree is constructed.", "Prim's algorithm: Start with a single vertex and repeatedly add the minimum-weight edge from the set of edges connecting the current tree to vertices outside it.", "Bellman-Ford algorithm: Find the shortest path from a source vertex to all other vertices in the graph."},
                {"P consists of problems that can be solved in polynomial time, NP consists of problems for which a proposed solution can be checked in polynomial time. Solving P vs. NP would have no practical implications.", "P consists of problems that can be solved quickly, NP consists of problems that may not have fast solutions but can be quickly verified. Proving P = NP would have significant consequences for cryptography and optimization.", "P consists of problems that can be solved in exponential time, NP consists of problems that can be solved in polynomial time. Solving P vs. NP would make all computational problems efficiently solvable.", "P consists of problems that are easy, NP consists of problems that are hard. Solving P vs. NP would not impact computer science or technology."}
        };

        char[] DMeasyAnswers = {
                'B',
                'D'
        };

        char[] DMmediumAnswers = {
                'C',
                'D'
        };

        char[] DMhardAnswers = {
                'C',
                'B'
        };
        String[] CSeasyQuestions = {
                "What does BNF stand for in computer science?",
                "In programming, what is the purpose of syntax?"
        };

        String[] CSmediumQuestions = {
                "In the context of ordered structures, what does a lattice represent?",
                "Which of the following best describes the concept of a 'partial order' in ordered structures and lattices?"
        };

        String[] CShardQuestions = {
                "What is a Binary Decision Diagram (BDD) primarily used for in computer science and digital circuit design?",
                "When considering Binary Decision Diagrams, what is the significance of 'reduction' or 'minimization'?"
        };

        String[][] CSeasyQuestionOptions = {
                {"Basic Numerical Format", "Backus-Naur Form", "Binary Notation Framework", "Basic Networking Function"},
                {"To define the meaning of variables", "To specify the order of execution of instructions", "To describe the structure and rules for constructing valid programs", "To control the flow of program execution"}
        };

        String[][] CSmediumQuestionOptions = {
                {"A data structure for organizing files in a computer", "A mathematical structure that describes a set with both a meet (infimum) and a join (supremum) operation", "A diagram used to visualize software architecture", "A scheduling algorithm used in operating systems"},
                {"A data structure that allows elements to be inserted and removed in any order", "A mathematical relation that is reflexive, antisymmetric, and transitive, defining a partial ordering on a set of elements", "A data structure for quick retrieval of elements in constant time", "A mathematical concept used to perform sorting operations on arrays"}
        };

        String[][] CShardQuestionOptions = {
                {"Representing arithmetic calculations in a compact form", "Modeling complex control flow in software programs", "Efficiently representing and manipulating Boolean functions", "Storing and retrieving binary data in a database"},
                {"A process of converting binary numbers to their hexadecimal equivalents", "The procedure of converting multi-level logic circuits to two-level representations", "A technique for increasing the depth and complexity of the BDD to handle larger functions", "The operation of transforming a BDD to its simplest and most compact form while preserving its functionality"}
        };

        char[] CSeasyAnswers = {
                'B',
                'C'
        };

        char[] CSmediumAnswers = {
                'B',
                'B'
        };

        char[] CShardAnswers = {
                'C',
                'D'
        };

        String[] COeasyQuestions = {
                "What is the purpose of the CPU in a computer system, and what are its primary components?",
                "Explain the concept of memory hierarchy in computer organization and the role of cache memory."
        };

        String[] COmediumQuestions = {
                "Describe the von Neumann architecture and its key components. How does it differ from Harvard architecture?",
                "Discuss the role of the Memory Management Unit (MMU) in a computer system and how it facilitates virtual memory."
        };

        String[] COhardQuestions = {
                "Explain the concept of pipelining in CPU design. Discuss the advantages and challenges associated with pipelined processors.",
                "Describe the differences between RISC (Reduced Instruction Set Computer) and CISC (Complex Instruction Set Computer) architectures. What are the advantages and disadvantages of each?"
        };

        String[][] COeasyQuestionOptions = {
                {"The CPU is responsible for long-term storage of data, and its primary components are the motherboard, RAM, and hard drive.", "The CPU performs arithmetic and logical operations, and its primary components are the control unit, ALU, and registers.", "The CPU manages input and output devices, and its primary components include the control unit, ALU, and registers.", "The CPU is responsible for displaying graphics on the monitor, and its primary components are the keyboard, mouse, and GPU."},
                {"Memory hierarchy is the order of different types of memory in terms of access speed, and cache memory provides high-speed storage for frequently accessed data.", "Memory hierarchy refers to organizing data alphabetically in a computer, and cache memory stores frequently used software applications.", "Memory hierarchy involves arranging memory modules by size, and cache memory is used for permanent data storage.", "Memory hierarchy refers to arranging data by importance, and cache memory is used for temporary storage of files."}
        };

        String[][] COmediumQuestionOptions = {
                {"Von Neumann architecture has a single memory for both data and instructions, while Harvard architecture has separate memory units for data and instructions.", "Von Neumann architecture separates data and instructions, while Harvard architecture combines them in the same memory.", "Von Neumann architecture uses multiple CPUs for parallel processing, while Harvard architecture uses a single CPU.", "Von Neumann architecture utilizes a unique data compression algorithm, while Harvard architecture relies on file compression."},
                {"The MMU is responsible for managing network connections in a computer, and it has no role in virtual memory.", "The MMU is part of the Central Processing Unit (CPU), and it facilitates virtual reality experiences.", "The MMU is involved in graphics rendering, and it improves the visual quality of computer games.", "The MMU translates virtual addresses to physical addresses and helps in the efficient use of physical memory for virtual memory systems."}
        };

        String[][] COhardQuestionOptions = {
                {"Pipelining is a technique to transport oil through CPU components, and it reduces energy consumption.", "Pipelining involves arranging CPUs in a pipeline for faster data transfer and has no advantages or challenges.", "Pipelining divides the CPU execution into stages, allowing for parallel processing, but it can introduce hazards like data hazards and control hazards.", "Pipelining increases the clock speed of the CPU, resulting in improved battery life in mobile devices."},
                {"RISC architectures typically have a simpler and smaller instruction set, while CISC architectures have more complex and diverse instructions.", "RISC and CISC architectures are identical, and there are no differences between them.", "RISC architectures have a large and complex instruction set, while CISC architectures have a reduced instruction set.", "RISC architectures are older and less efficient, while CISC architectures are more modern and faster."}
        };

        char[] COeasyAnswers = {
                'B',
                'A'
        };

        char[] COmediumAnswers = {
                'A',
                'D'
        };

        char[] COhardAnswers = {
                'C',
                'A'
        };

        String[] easyQuestions = new String[0];
        String[] mediumQuestions = new String[0];
        String[] hardQuestions = new String[0];
        char[] easyAnswers = new char[0];
        char[] mediumAnswers = new char[0];
        char[] hardAnswers = new char[0];
        String[][] easyQuestionOptions = new String[0][];
        String[][] mediumQuestionOptions = new String[0][];
        String[][] hardQuestionOptions = new String[0][];

        if ((subject.equals("DiscreteMaths"))) {
            easyQuestions = DMeasyQuestions;
            mediumQuestions = DMmediumQuestions;
            hardQuestions = DMhardQuestions;
            easyAnswers = DMeasyAnswers;
            mediumAnswers = DMmediumAnswers;
            hardAnswers = DMhardAnswers;
            easyQuestionOptions = DMeasyQuestionOptions;
            mediumQuestionOptions = DMmediumQuestionOptions;
            hardQuestionOptions = DMhardQuestionOptions;
        }

        if ((subject.equals("ComputerScience"))) {
            easyQuestions = CSeasyQuestions;
            mediumQuestions = CSmediumQuestions;
            hardQuestions = CShardQuestions;
            easyAnswers = CSeasyAnswers;
            mediumAnswers = CSmediumAnswers;
            hardAnswers = CShardAnswers;
            easyQuestionOptions = CSeasyQuestionOptions;
            mediumQuestionOptions = CSmediumQuestionOptions;
            hardQuestionOptions = CShardQuestionOptions;
        }

        if ((subject.equals("ComputerOrganization"))) {
            easyQuestions = COeasyQuestions;
            mediumQuestions = COmediumQuestions;
            hardQuestions = COhardQuestions;
            easyAnswers = COeasyAnswers;
            mediumAnswers = COmediumAnswers;
            hardAnswers = COhardAnswers;
            easyQuestionOptions = COeasyQuestionOptions;
            mediumQuestionOptions = COmediumQuestionOptions;
            hardQuestionOptions = COhardQuestionOptions;
        }

        QuizFrame game = new QuizFrame(Difficulty, easyQuestions, mediumQuestions, hardQuestions, easyAnswers, mediumAnswers, hardAnswers, easyQuestionOptions, mediumQuestionOptions, hardQuestionOptions);
    }


    public QuizFrame(String Difficulty, String[] easyQuestions, String[] mediumQuestions, String[] hardQuestions, char[] easyAnswers, char[] mediumAnswers, char[] hardAnswers, String[][] easyQuestionOptions, String[][] mediumQuestionOptions, String[][] hardQuestionOptions) {

        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setResizable(false);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        total_questions = 4;
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




