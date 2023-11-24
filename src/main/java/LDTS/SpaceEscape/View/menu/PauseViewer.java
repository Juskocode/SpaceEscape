package LDTS.SpaceEscape.View.menu;

import LDTS.SpaceEscape.Gui.GUI;
import LDTS.SpaceEscape.Struct.game.Position;
import LDTS.SpaceEscape.Struct.menu.Pause;
import LDTS.SpaceEscape.View.Colors;

public class PauseViewer extends MenuViewer<Pause> {

    public PauseViewer(Pause model) {
        super(model, new Position(8, 13));
    }

    @Override
    protected void drawInsideElements(GUI gui) {
        drawTitle(gui, "Pause", Colors.ORANGE.getHex());
    }
}