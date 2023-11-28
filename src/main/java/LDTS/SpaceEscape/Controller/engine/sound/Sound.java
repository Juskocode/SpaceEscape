package LDTS.SpaceEscape.Controller.engine.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Sound {
    private final Clip sound;
    private float volume;

    private final FloatControl floatControl;

    private long lastPlayTime;
    private static final long INPUT_INTERVAL = 300;

    public Sound(String soundFile) {
        this.sound = load(soundFile);
        assert sound != null;
        this.floatControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);
        setVolume(0.2);
    }

    private Clip load(String soundFile) throws NullPointerException {
        try {
            File file = new File(soundFile);

            if (!file.exists()) throw new RuntimeException("Sound: file not found: " + soundFile);

            AudioInputStream audioInput = AudioSystem.getAudioInputStream(file);
            Clip soundClip = AudioSystem.getClip();
            soundClip.open(audioInput);

            return soundClip;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void play() {
        long currentTime = System.currentTimeMillis();

        if(currentTime - lastPlayTime > INPUT_INTERVAL) {
            sound.setFramePosition(0);
            sound.start();
            lastPlayTime = currentTime;
        }
    }

    public void loop() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastPlayTime > INPUT_INTERVAL) {
            sound.loop(Clip.LOOP_CONTINUOUSLY);
            lastPlayTime = currentTime;
        }
    }

    public void stop() {
        sound.stop();
    }

    public void setVolume(double volume) {
        if (volume < 0.0 || volume > 1.0) throw new IllegalArgumentException("Volume not valid: " + volume);
        float value = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
        floatControl.setValue(value);
        this.volume = value;
    }

    public boolean isRunning() {
        return sound.isRunning();
    }

    public void toggleMute() {
        if (floatControl.getValue() == -80.0) {
            floatControl.setValue(volume);
        } else {
            floatControl.setValue(-80.0f);
        }
    }
}