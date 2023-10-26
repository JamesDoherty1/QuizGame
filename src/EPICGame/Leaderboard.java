package EPICGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leaderboard implements ActionListener {
    //GUI Components
    JFrame frame = new JFrame();
    JButton first = new JButton();
    JButton second = new JButton();
    JButton third = new JButton();
    JButton fourth = new JButton();
    JButton fifth = new JButton();

    Leaderboard(){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(313, 337);
        frame.setLocation(1094, 230);
        frame.setVisible(true);
        frame.setResizable(false);
        this.frame.setLayout((LayoutManager) null);

        first.setBounds(0, 0, 300, 60);
        first.setFont(new Font("Black Ops One",Font.PLAIN,23));
        first.setBackground(new Color(20,255,255));
        first.setFocusable(false);
        first.setText("First");
        frame.add(first);

        second.setBounds(0, 60, 300, 60);
        second.setBackground(new Color(20,255,255));
        second.setFont(new Font("Black Ops One",Font.PLAIN,23));
        second.setFocusable(false);
        second.setText("Second");
        frame.add(second);

        third.setBounds(0, 120, 300, 60);
        third.setBackground(new Color(20,255,255));
        third.setFont(new Font("Black Ops One",Font.PLAIN,23));
        third.setFocusable(false);
        third.setText("Third");
        frame.add(third);

        fourth.setBounds(0, 180, 300, 60);
        fourth.setBackground(new Color(20,255,255));
        fourth.setFont(new Font("Black Ops One",Font.PLAIN,23));
        fourth.setFocusable(false);
        fourth.setText("Fourth");
        frame.add(fourth);

        fifth.setBounds(0, 240, 300, 60);
        fifth.setBackground(new Color(20,255,255));
        fifth.setFont(new Font("Black Ops One",Font.PLAIN,23));
        fifth.setFocusable(false);
        fifth.setText("Fifth");
        frame.add(fifth);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==first){
        }
        if(e.getSource()==second){
        }
        if(e.getSource()==third){
        }
        if(e.getSource()==fourth){
        }
        if(e.getSource()==fifth){
        }
    }
}
