package EPICGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SettingsPage {
    JFrame frame = new JFrame();
    JLabel settingsLabel = new JLabel("Settings");
    JLabel musicLabel = new JLabel("Music");
    ImageIcon backgroundImage = new ImageIcon("images/SettingsPageBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    SettingsPage() {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calculate the center of the screen
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

        // Calculate the positions of the components relative to the screen center
        settingsLabel.setBounds(centerX - 150, centerY - 300, 700, 80);
        settingsLabel.setFont(new Font("Orbitron", Font.BOLD, 70));
        settingsLabel.setForeground(new Color(20, 255, 255));
        this.frame.add(this.settingsLabel);

        musicLabel.setBounds(centerX - 250, centerY - 50, 500, 35);
        musicLabel.setFont(new Font("Orbitron", Font.PLAIN, 30));
        musicLabel.setForeground(new Color(255, 215, 0));
        this.frame.add(this.musicLabel);

        JButton musicVolume = new JButton("Mute/Unmute");
        musicVolume.setBounds(centerX - 150, centerY - 60, 300, 60);
        musicVolume.setFont(new Font("Black Ops One", Font.PLAIN, 25));
        musicVolume.setBackground(new Color(0, 255, 255));
        musicVolume.setFocusable(false);
        this.frame.add(musicVolume);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(centerX - 75, centerY + 200, 150, 50);
        returnButton.setFont(new Font("Black Ops One", Font.PLAIN, 23));
        returnButton.setBackground(new Color(0, 255, 255));
        returnButton.setFocusable(false);
        this.frame.add(returnButton);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout(null);
        this.frame.setVisible(true);

        musicVolume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Implement your action here
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new WelcomePage("again");
                // Send "again" as a String
            }
        });
    }

    public static void main(String[] args) {
        new SettingsPage();
    }
}
