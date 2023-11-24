package LDTS.SpaceEscape.View.menu;

import LDTS.SpaceEscape.Gui.GUI;
import LDTS.SpaceEscape.Struct.menu.Leaderboard;
import LDTS.SpaceEscape.Struct.game.Position;
import LDTS.SpaceEscape.View.Colors;
public class LeaderboardViewer extends MenuViewer<Leaderboard> {

    public LeaderboardViewer(Leaderboard model) {
        super(model, new Position(8, 13));
    }

    protected void drawInsideElements(GUI gui) {
        drawTitle(gui, "Leaderboard", Colors.WHITE.getHex());

        for (int i = 0; i < getModel().getSize(); i++) {
            drawText(gui, new Position(8, 13 + i), getModel().getLine(i), Colors.ORANGE.getHex());
        }
    }

    @Override
    public void drawOptions(GUI gui) {

    }
}
