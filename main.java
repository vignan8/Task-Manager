import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;

public class MusicPlayer implements LineListener {
    private File musicFile;
    private Clip clip;
    private FloatControl gainControl;
    private boolean isPlaying;

    public MusicPlayer(String filePath) {
        musicFile = new File(filePath);
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musicFile);
            clip = AudioSystem.getClip();
            clip.addLineListener(this);
            clip.open(audioInputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            isPlaying = false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void play() {
        clip.start();
        isPlaying = true;
    }

    public void pause() {
        clip.stop();
        isPlaying = false;
    }

    public void resume() {
        clip.start();
        isPlaying = true;
    }

    public void stop() {
        clip.stop();
        clip.setFramePosition(0);
        isPlaying = false;
    }

    public void setVolume(float volume) {
        gainControl.setValue(volume);
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
        if (type == LineEvent.Type.STOP) {
            isPlaying = false;
        }
    }
}
