package window;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MusicManager {
    private Player currentPlayer;

    public void playMusic(String filePath) {
        stopMusic(); // Stop any currently playing music
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(filePath);
                BufferedInputStream bis = new BufferedInputStream(fis);
                currentPlayer = new Player(bis);
                currentPlayer.play();
            } catch (JavaLayerException | FileNotFoundException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void stopMusic() {
        if (currentPlayer != null) {
            currentPlayer.close();
            currentPlayer = null;
        }
    }
}
