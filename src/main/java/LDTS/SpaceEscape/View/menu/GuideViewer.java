package LDTS.SpaceEscape.View.menu;

import LDTS.SpaceEscape.Gui.GUI;
import LDTS.SpaceEscape.Model.game.Position;
import LDTS.SpaceEscape.Model.menu.Guide;
import LDTS.SpaceEscape.View.Colors;
public class GuideViewer extends MenuViewer<Guide> {

    public GuideViewer(Guide model) {
        super(model, new Position(2, 7));
    }

    public void drawInsideElements(GUI gui) {
        drawTitle(gui, "Instructions", Colors.WHITE.getHex());

        for (int i = 0; i < getModel().getSize(); i++) {
            drawText(gui, new Position(2, 7 + i), getModel().getLine(i), Colors.ORANGE.getHex());
        }
    }

    @Override
    public void drawOptions(GUI gui) {

    }
}
