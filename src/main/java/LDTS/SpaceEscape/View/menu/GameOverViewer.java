package LDTS.SpaceEscape.View.menu;

import LDTS.SpaceEscape.Gui.GUI;
import LDTS.SpaceEscape.Model.game.Position;
import LDTS.SpaceEscape.Model.menu.GameOver;
import LDTS.SpaceEscape.View.Colors;
public class GameOverViewer extends MenuViewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model, new Position(GameOver.MARGIN - 1, 21));
    }

    public void drawInsideElements(GUI gui) {
        drawText(gui, new Position(GameOver.MARGIN, 13), "G A M E   O V E R", Colors.ORANGE.getHex());
        drawText(gui, new Position(GameOver.MARGIN, 15), "Score: " + getModel().getScore(), Colors.WHITE.getHex());
        drawText(gui, new Position(GameOver.MARGIN, 17), "Enter your name:", Colors.WHITE.getHex());
        drawText(gui, new Position(GameOver.MARGIN, 19), getModel().getUsername(), Colors.ORANGE.getHex());
    }
}

