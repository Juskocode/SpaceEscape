package LDTS.SpaceEscape.Controller;

import LDTS.SpaceEscape.App;

import com.googlecode.lanterna.input.KeyStroke;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;


public abstract class Controller<GAME>{

    public Controller(GAME model) {
        this.model = model;
    }

    public GAME getModel(){
        return model;
    }

    public abstract void process(App app, KeyStroke keys) throws IOException, FontFormatException, URISyntaxException;

    private final GAME model;
}
