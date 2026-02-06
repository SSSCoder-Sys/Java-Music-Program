import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // How to play AUDIO with JAVA (.wav, .au, .aiff)

        //TODO
        String filepath = "src/By Myself - The Grey Room _ Clark Sims.wav";

        File file = new File(filepath);

        try (Scanner scanner = new Scanner(System.in);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)) {

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            System.out.println("+++++++++++++++++++++");
            System.out.println("  JAVA MUSIC PLAYER");
            System.out.println("+++++++++++++++++++++");

            String response = "";

            while(!response.equals("Q")) {

                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.print("Enter your choice: ");

                response = scanner.next().toUpperCase();

                switch (response) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("INVALID CHOICE!");
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        catch (LineUnavailableException e) {
            System.out.println("Unable to access audio resource");
        }
        catch (UnsupportedAudioFileException e) {
            System.out.println("Audio file not supported");
        }
        catch (IOException e) {
            System.out.println("System Error! Something went wrong. ErrorCode: \"101\"");
        }
        finally {
            System.out.println("Bye!");
        }

    }
}
