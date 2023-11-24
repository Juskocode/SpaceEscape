package LDTS.SpaceEscape.Controller.sound;

public class SoundState {
    private static SoundState INSTANCE = null;

    private final Sound menuBackgroundMusic;
    private final Sound gameBackgroundMusic;
    private final Sound selectEffectSound;
    private final Sound choiceEffectSound;
    private final Sound startEffectSound;
    private final Sound gameOverSound;

    private SoundState() {
        this.menuBackgroundMusic = new Sound("src/main/resources/sounds/menu_background.wav");
        this.gameBackgroundMusic = new Sound("src/main/resources/sounds/game_background.wav");
        this.selectEffectSound = new Sound("src/main/resources/sounds/select_effect.wav");
        this.choiceEffectSound = new Sound("src/main/resources/sounds/choice_effect.wav");
        this.startEffectSound = new Sound("src/main/resources/sounds/start_effect.wav");
        this.gameOverSound = new Sound("src/main/resources/sounds/game_over_effect.wav");


        this.menuBackgroundMusic.setVolume(0.05);
    }

    public static SoundState getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SoundState();
        }
        return INSTANCE;
    }

    public void setBackgroundSound(Audio audio) {
        switch (audio) {
            case MENU_AUDIO:
                gameBackgroundMusic.stop();
                menuBackgroundMusic.loop();
                break;
            case GAME_AUDIO:
                menuBackgroundMusic.stop();
                gameBackgroundMusic.loop();
                break;
        }
    }

    public void pauseBackgroundSound() {
        gameBackgroundMusic.stop();
    }

    public void resumeBackgroundSound() {
        gameBackgroundMusic.loop();
    }

    public void playSoundEffect(SOUNDFX effect) {
        switch (effect) {
            case MENU_SELECT:
                selectEffectSound.play();
                break;
            case MENU_CHOICE:
                choiceEffectSound.play();
                break;
            case GAME_START:
                startEffectSound.play();
                break;
            case GAME_OVER:
                gameOverSound.play();
                break;
            //TODO ADD MORE SOUND FX
        }
    }


    public void stopAll() {
        menuBackgroundMusic.stop();
        gameBackgroundMusic.stop();
    }

    public void toggleSoundMute() {
        selectEffectSound.toggleMute();
        choiceEffectSound.toggleMute();
        startEffectSound.toggleMute();
        gameOverSound.toggleMute();

    }

    public void toggleGameMusicMute() {
        gameBackgroundMusic.toggleMute();
    }

    public void toggleMenuMusicMute() {
        menuBackgroundMusic.toggleMute();
    }
}