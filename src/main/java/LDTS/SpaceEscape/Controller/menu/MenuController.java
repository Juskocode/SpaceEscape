package LDTS.SpaceEscape.Controller.menu;

import LDTS.SpaceEscape.Controller.sound.SOUNDFX;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import LDTS.SpaceEscape.App;
import LDTS.SpaceEscape.Controller.sound.SoundState;
import LDTS.SpaceEscape.Model.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.EnumMap;

public abstract class MenuController<T extends Menu> extends Controller<T> implements MenuInterface {

    private long lastInputTime; // Track last input time
    private static final long INPUT_INTERVAL = 300;
    public MenuController(T model) {
        super(model);
    }

    private EnumMap<KeyType, Long> keyReleaseTimeMap = new EnumMap<>(KeyType.class); // Track key release times

    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;

        KeyType keyType = key.getKeyType();

        long currentTime = System.currentTimeMillis();
        Long releaseTime = keyReleaseTimeMap.get(keyType);

        if (releaseTime != null && currentTime - releaseTime < INPUT_INTERVAL) {
            return; // Skip if key was released within the interval
        }

        if (currentTime - lastInputTime < INPUT_INTERVAL) {
            return; // Abort if the time between inputs is too short
        }

        lastInputTime = currentTime; // Update last input time

        switch (keyType) {
            case ArrowUp:
                getModel().previousOption();
                break;
            case ArrowDown:
                getModel().nextOption();
                break;
            case Enter:
                SoundState.getInstance().playSoundEffect(SOUNDFX.MENU_CHOICE);
                optionSelected(game);
                break;
            case Character:
                Character c = key.getCharacter();
                if (c != null) {
                    charSelected(key);
                }
                break;
            case Escape:
                escapePressed(game);
                break;
            case Backspace:
                backspacePressed(game);
                break;
            default:
                break;
        }
    }

    // Call this method when a key is released
    public void keyReleased(KeyType keyType) {
        keyReleaseTimeMap.put(keyType, System.currentTimeMillis());
    }


    public void charSelected(KeyStroke key) {
        if (key.getCharacter() == 'm') {
            SoundState.getInstance().toggleMenuMusicMute();
        }
        if (key.getCharacter() == 's') {
            SoundState.getInstance().toggleSoundMute();
        }
    }
}
