package EPICGame;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;


public class ComputerScience implements ActionListener {
    JFrame frame = new JFrame();
    JButton returnButton = new JButton("Return");

    ComputerScience() {

        this.returnButton.setBounds(720, 410, 100, 25);
        this.returnButton.setFocusable(false);
        this.returnButton.addActionListener(this);

        this.frame.add(this.returnButton);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager) null);
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.returnButton) {
            this.frame.dispose();
            new WelcomePage("again");
        }
    }
}

