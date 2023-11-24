package LDTS.SpaceEscape.View.menu;

import LDTS.SpaceEscape.Gui.GUI;
import LDTS.SpaceEscape.Struct.game.Position;
import LDTS.SpaceEscape.Struct.menu.Main;
import LDTS.SpaceEscape.View.Colors;
public class MainViewer extends MenuViewer<Main> {

    public MainViewer(Main mainMenu) {
        super(mainMenu, new Position(8, 13));
    }

    protected void drawInsideElements(GUI gui) {
        drawTitle(gui, "Main Menu", Colors.ORANGE.getHex());

        String[] curiosity = getModel().getFunfact().split("\n");

        gui.drawPixel(new Position(1, 20), (char) 137, Colors.ORANGE.getHex(), Colors.MENU_BACKGROUND.getHex());
        for (int i = 1; i < curiosity.length; i++) {
            gui.drawLine(new Position(1, 20 + i), curiosity[i], Colors.GREY.getHex());
        }
    }
}
