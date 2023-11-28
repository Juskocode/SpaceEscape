package LDTS.SpaceEscape.Controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import LDTS.SpaceEscape.App;
import LDTS.SpaceEscape.Model.menu.GameOver;
import static LDTS.SpaceEscape.State.AppState.GAME_STATE;
import static LDTS.SpaceEscape.State.AppState.MENU_STATE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GameOverController extends MenuController<GameOver> {

    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void optionSelected(App game) throws IOException {

    }

    @Override
    public void charSelected(KeyStroke key) {

    }

    @Override
    public void escapePressed(App game) throws IOException {

    }

    @Override
    public void backspacePressed(App game) {

    }


}