package LDTS.SpaceEscape.Controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import LDTS.SpaceEscape.App;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public abstract class Controller<T> {
    private final T model;

    public Controller(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

    public abstract void step(App game, KeyStroke key) throws IOException, URISyntaxException, FontFormatException;
}
