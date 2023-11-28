package LDTS.SpaceEscape.Controller.menu;

import LDTS.SpaceEscape.App;

import java.io.IOException;

public interface MenuInterface {
    void optionSelected(App game) throws IOException;

    void escapePressed(App game) throws IOException;

    void backspacePressed(App game) throws IOException;
}
