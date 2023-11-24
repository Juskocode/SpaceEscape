package git.juskocode.controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import git.juskocode.App;
import git.juskocode.controller.sound.SOUNDFX;
import git.juskocode.controller.sound.SoundState;
import git.juskocode.struct.menu.Menu;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class MenuController<T extends Menu> extends Controller<T> implements MenuInterface {
    public MenuController(T model) {
        super(model);
    }

    @Override
    public void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException {
        if (key == null) return;
        if (key.getKeyType() == KeyType.ArrowUp) {
            getModel().previousOption();
        }
        if (key.getKeyType() == KeyType.ArrowDown) {
            getModel().nextOption();
        }
        if (key.getKeyType() == KeyType.Enter) {
            SoundState.getInstance().playSoundEffect(SOUNDFX.MENU_CHOICE);
            optionSelected(game);
        }
        if (key.getKeyType() == KeyType.Character) {
            if (key.getCharacter() == null) return;
            charSelected(key);
        }
        if (key.getKeyType() == KeyType.Escape) {
            escapePressed(game);
        }
        if (key.getKeyType() == KeyType.Backspace) {
            backspacePressed(game);
        }
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
