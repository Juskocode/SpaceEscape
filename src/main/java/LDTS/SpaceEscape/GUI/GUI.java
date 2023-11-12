package LDTS.SpaceEscape.GUI;

import LDTS.SpaceEscape.Model.game.Position;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.IOException;

public interface GUI {
    KeyStroke getNextAction() throws IOException;

    void drawPixel(Position position, char c, String color, String backgroundColor);

    void paintPixel(Position position, String color);

    void drawText(Position position, String text, String color, String backgroundColor);

    void drawLine(Position position, String text, String color);

    void paintBackground(String color);

    void drawRectangle(Position position, int width, int height, String color);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    int getWidth();

    int getHeight();
}
