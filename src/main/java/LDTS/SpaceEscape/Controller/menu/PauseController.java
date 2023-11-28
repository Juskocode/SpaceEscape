package LDTS.SpaceEscape.Controller.menu;

import LDTS.SpaceEscape.App;

import LDTS.SpaceEscape.Model.menu.Pause;

import java.io.IOException;

import static LDTS.SpaceEscape.State.AppState.*;

public class PauseController extends MenuController<Pause> {

    public PauseController(Pause pause) {
        super(pause);
    }

    public void optionSelected(App game) throws IOException {

        if (getModel().isSelectedRestart()) game.setState(GAME_STATE);
        if (getModel().isSelectedExit()) game.setState(MENU_STATE);
    }

    @Override
    public void escapePressed(App game) throws IOException {

    }

    @Override
    public void backspacePressed(App game) {
    }
}