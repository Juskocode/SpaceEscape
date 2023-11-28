package LDTS.SpaceEscape;

import com.googlecode.lanterna.input.KeyStroke;
import LDTS.SpaceEscape.Controller.menu.*;
import LDTS.SpaceEscape.Controller.menu.TextReaderController;
import LDTS.SpaceEscape.Controller.sound.Audio;
import LDTS.SpaceEscape.Controller.sound.SoundState;
import LDTS.SpaceEscape.Controller.sound.SoundState;
import LDTS.SpaceEscape.GUI.LanternaGUI;
import LDTS.SpaceEscape.Model.menu.*;
import LDTS.SpaceEscape.State.AppState;
import LDTS.SpaceEscape.View.Viewer;
import LDTS.SpaceEscape.View.menu.*;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

import static LDTS.SpaceEscape.State.AppState.MENU_STATE;
import static LDTS.SpaceEscape.State.AppState.PAUSE_STATE;

public class App {
    private final LanternaGUI gui;
    private Controller controller;

    private Viewer viewer;
    private AppState state;
    private Main mainMenu;
    private Pause pause;
    private Game game;
    private Game prevGame;

    public App() throws IOException, URISyntaxException, FontFormatException {
        this.gui = new LanternaGUI();
        this.state = MENU_STATE;
        this.mainMenu = new Main();
        this.controller = new MainMenuController(mainMenu);
        this.viewer = new MainViewer(mainMenu);
        SoundState.getInstance().setBackgroundSound(Audio.MENU_AUDIO);
    }

    public static void main(String[] args) {
        try {
            new App().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void start() throws Exception {
        int FPS = 12;
        int frameTime = 1000 / FPS;
        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            KeyStroke next_key = gui.getNextAction();

            controller.step(this, next_key);
            viewer.draw(gui);


            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        gui.close();
    }

    public void exit() {
        this.state = null;
        SoundState.getInstance().stopAll();
    }

    public void setState(AppState state) throws IOException {
        if (state == PAUSE_STATE) {
            this.prevGame = this.game;
        }
        this.state = state;
        switch (state) {
            case MENU_STATE:
                SoundState.getInstance().setBackgroundSound(Audio.MENU_AUDIO);
                this.mainMenu = new Main();
                this.controller = new MainMenuController(mainMenu);
                this.viewer = new MainViewer(mainMenu);
                break;
            case LEADERBOARD_STATE:
                Leaderboard leaderboard = new Leaderboard();
                this.controller = new TextReaderController(leaderboard);
                this.viewer = new LeaderboardViewer(leaderboard);
                break;
            case GUIDE_STATE:
                Guide guide = new Guide();
                this.controller = new TextReaderController(guide);
                this.viewer = new GuideViewer(guide);
                break;
            case PAUSE_STATE:
                SoundState.getInstance().pauseBackgroundSound();
                this.pause = new Pause();
                this.controller = new PauseController(pause);
                this.viewer = new PauseViewer(pause);
                break;
            case GAME_OVER_STATE:
                SoundState.getInstance().pauseBackgroundSound();
                GameOver gameOver = new GameOver(0);
                this.controller = new GameOverController(gameOver);
                this.viewer = new GameOverViewer(gameOver);
                break;
        }
    }
}