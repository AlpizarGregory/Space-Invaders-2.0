package Objects;
import javax.sound.sampled.*;
import java.io.File;

/**
 * Se encarga de reproducir audio
 */
public class Audio {
    private Clip clip;

    /**
     * Constructor de Audio, reproduce la pista
     * @param path Es la ruta de la pista de WAV
     */
    public Audio(String path) {
        try
        {
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            clip.start();
        }
        catch (Exception exc)
        {
            exc.printStackTrace(System.out);
        }
    }

    /**
     * Termina la pista de audio
     */
    public void Stop() {
        clip.stop();
    }
}