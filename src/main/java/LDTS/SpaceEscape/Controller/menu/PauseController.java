package git.juskocode.controller.menu;

import git.juskocode.App;


import git.juskocode.App;
import git.juskocode.struct.menu.Pause;

import java.io.IOException;

import static git.juskocode.state.AppState.*;

public class PauseController extends MenuController<Pause> {

    public PauseController(Pause pause) {
        super(pause);
    }

    public void optionSelected(App game) throws IOException {
        if (getModel().isSelectedResume()) {
            game.setState(PREV_GAME_STATE);
        }
        if (getModel().isSelectedRestart()) game.setState(GAME_STATE);
        if (getModel().isSelectedExit()) game.setState(MENU_STATE);
    }

    @Override
    public void escapePressed(App game) throws IOException {
        game.setState(PREV_GAME_STATE);
    }

    @Override
    public void backspacePressed(App game) {
    }
}