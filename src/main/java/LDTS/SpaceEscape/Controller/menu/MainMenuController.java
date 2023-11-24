package LDTS.SpaceEscape.Controller.menu;

import LDTS.SpaceEscape.App;
import LDTS.SpaceEscape.controller.sound.SOUNDFX;
import LDTS.SpaceEscape.controller.sound.SoundState;
import LDTS.SpaceEscape.Model.menu.Main;

import java.io.IOException;

import static LDTS.SpaceEscape.state.AppState.*;

public class MainMenuController extends MenuController<Main> {

    public MainMenuController(Main mainMenu) {
        super(mainMenu);
    }

    public void optionSelected(App game) throws IOException {
        SoundState.getInstance().playSoundEffect(SOUNDFX.MENU_CHOICE);
        if (getModel().isSelectedStart()) {
            game.setState(GAME_STATE);
            SoundState.getInstance().playSoundEffect(SOUNDFX.GAME_START);
            return;
        }
        if (getModel().isSelectedExit()) game.exit();
        if (getModel().isSelectedLeaderboard()) game.setState(LEADERBOARD_STATE);
        if (getModel().isSelectedInstructions()) game.setState(GUIDE_STATE);
    }

    @Override
    public void escapePressed(App game) {
    }

    @Override
    public void backspacePressed(App game) {
    }
}