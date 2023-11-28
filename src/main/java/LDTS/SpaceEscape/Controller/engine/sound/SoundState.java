package LDTS.SpaceEscape.Controller.engine.sound;


public class SoundState {
    private static SoundState INSTANCE = null;

    private final Sound menuBackgroundMusic;
    private final Sound selectEffectSound;
    private final Sound choiceEffectSound;

    private SoundState() {
        this.menuBackgroundMusic = new Sound("src/main/resources/sounds/menu_background.wav");
        this.selectEffectSound = new Sound("src/main/resources/sounds/select_effect.wav");
        this.choiceEffectSound = new Sound("src/main/resources/sounds/choice_effect.wav");

        this.menuBackgroundMusic.setVolume(0.05);
    }

    public static SoundState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SoundState();
        }
        return INSTANCE;
    }

    public void setBackgroundSound(Ost audio) {
        menuBackgroundMusic.loop();
    }


    public void playSoundEffect(SOUNDFX effect) {
        switch (effect) {
            case MENU_SELECT:
                selectEffectSound.play();
                break;
            case MENU_CHOICE:
                choiceEffectSound.play();
                break;
            //TODO ADD MORE SOUND FX
        }
    }


    public void stopAll() {
        menuBackgroundMusic.stop();
    }

    public void toggleSoundMute() {
        selectEffectSound.toggleMute();
        choiceEffectSound.toggleMute();
    }

    public void toggleMenuMusicMute() {
        menuBackgroundMusic.toggleMute();
    }
}
