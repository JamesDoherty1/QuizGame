package EPICGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SettingsPage {
    JFrame frame = new JFrame();
    JLabel settingsLabel = new JLabel("Settings");
    JLabel musicLabel = new JLabel("Music");
    ImageIcon backgroundImage = new ImageIcon("C:\\Users\\jkdoh\\IdeaProjects\\EPICEndeavourGame\\src\\EPICGame\\SettingsPageBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);


    SettingsPage() {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        settingsLabel.setBounds(610, 40, 1000, 80);
        settingsLabel.setFont(new Font((String) null, 0, 25));
        settingsLabel.setForeground(new Color(20, 255, 255));
        settingsLabel.setFont(new Font("Orbitron", Font.BOLD, 70));
        this.frame.add(this.settingsLabel);

        musicLabel.setBounds(530, 210, 500, 35);
        musicLabel.setFont(new Font((String) null, 2, 25));
        musicLabel.setFont(new Font("Orbitron", Font.PLAIN, 30));
        musicLabel.setForeground(new Color(255,215,0));
        this.frame.add(this.musicLabel);

        JButton musicVolume = new JButton("Music Volume");
        musicVolume.setBounds(640, 200, 300, 60);
        musicVolume.setFont(new Font("Black Ops One", Font.PLAIN, 25));
        musicVolume.setBackground(new Color(0, 255, 255));
        musicVolume.setFocusable(false);
        this.frame.add(musicVolume);

        JButton returnButton = new JButton("Return");
        returnButton.setBounds(680, 650, 150, 50);
        returnButton.setFont(new Font("Black Ops One", Font.PLAIN, 23));
        returnButton.setBackground(new Color(0, 255, 255));
        returnButton.setFocusable(false);
        this.frame.add(returnButton);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frame.setLayout((LayoutManager) null);
        this.frame.setVisible(true);


        musicVolume.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new WelcomePage("again");
                //Send again as String
            }
        });
    }


    public static void main(String[] args) {
        new SettingsPage();
        //Open SettingsPage constructor from main
    }
}

