import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.*;

public class Music {

 public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException{
  
  Scanner scanner = new Scanner(System.in);
  
  File file = new File("Faith - Vibe Tracks.wav");
  AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
  Clip clip = AudioSystem.getClip();
  clip.open(audioStream);
  
  String response = "";
 
  
  while(!response.equals("Q")) {
   System.out.println("P = play, S = Stop, R = Reset, Q = Quit");
   System.out.print("Enter your choice: ");
   
   response = scanner.next();
   response = response.toUpperCase();
   
   switch(response) {
    case ("P"): clip.start();
    break;
    case ("S"): clip.stop();
    break;
    case ("R"): clip.setMicrosecondPosition(0);
    break;
    case ("Q"): clip.close();
    break;
    default: System.out.println("Not a valid response");
   }
   
  }
  System.out.println("Byeeee!"); 
 }
}
// make an algorithm in java that sorts out 1,000,000 numbers in order from smallest to biggest in the fastest time, also include a code that generates random 1,000,000 numbers, and add comments