package LDTS.SpaceEscape.Controller.menu;

import LDTS.SpaceEscape.App;

import LDTS.SpaceEscape.Model.menu.TextReader;

import java.io.IOException;

import static LDTS.SpaceEscape.State.AppState.MENU_STATE;

public class TextReaderController extends MenuController<TextReader> {

    public TextReaderController(TextReader textMenu) {
        super(textMenu);
    }

    @Override
    public void escapePressed(App game) throws IOException {
        game.setState(MENU_STATE);
    }

    @Override
    public void optionSelected(App game) {
    }

    @Override
    public void backspacePressed(App game) {
    }
}
