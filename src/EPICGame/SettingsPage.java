package EPICGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;

public class SettingsPage {
    private Clip backgroundMusicClip;
    private boolean isMusicPlaying = false;

    JFrame frame = new JFrame();
    JLabel settingsLabel = new JLabel("Settings");
    JLabel musicLabel = new JLabel("Music");
    ImageIcon backgroundImage = new ImageIcon("images/SettingsPageBackground.jpg");
    JLabel backgroundLabel = new JLabel(backgroundImage);

    private void playBackgroundMusic() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("97 All Night (Tropical House).wav"));
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(audioInputStream);
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);  // Loop the music
            isMusicPlaying = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void toggleBackgroundMusic() {
        if (isMusicPlaying) {
            backgroundMusicClip.stop();
        } else {
            backgroundMusicClip.start(); // Resume from where it stopped
        }
        isMusicPlaying = !isMusicPlaying;
    }


    SettingsPage() {
        this.frame.add(backgroundLabel);
        this.frame.setContentPane(backgroundLabel);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;

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
                toggleBackgroundMusic();
            }
        });

        returnButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new WelcomePage("again");
            }
        });

        // Start playing background music
        playBackgroundMusic();
    }

    public static void main(String[] args) {
        new SettingsPage();
    }
}
