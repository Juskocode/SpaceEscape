package LDTS.SpaceEscape.View.menu;


import LDTS.SpaceEscape.GUI.GUI;
import LDTS.SpaceEscape.Model.game.Position;
import LDTS.SpaceEscape.Model.menu.GameOver;
import LDTS.SpaceEscape.View.Colors;
public class GameOverViewer extends MenuViewer<GameOver> {

    public GameOverViewer(GameOver model) {
        super(model, new Position(0, 0));
    }

    @Override
    protected void drawElements(GUI gui) {

    }

    @Override
    protected void drawInsideElements(GUI gui) {

    }


}

