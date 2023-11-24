package LDTS.SpaceEscape.struct.menu;

import LDTS.SpaceEscape.gui.LanternaGUI;

import java.util.Arrays;

public class GameOver extends Menu {
    public static final int MARGIN = 6;
    private static final int MAX_LENGTH = LanternaGUI.WIDTH - 2 * MARGIN;
    private String username;
    private final Integer score;

    public GameOver(int score) {
        this.username = "";
        this.score = score;
        this.options = Arrays.asList("Restart", "Main Menu");
    }

    public String getUsername() {
        return username;
    }

    public void addChar(Character character) {
        if (username.length() < MAX_LENGTH) {
            username += character;
        }
    }

    public void removeChar() {
        if (username.length() > 0) {
            username = username.substring(0, username.length() - 1);
        }
    }

    public Integer getScore() {
        return score;
    }

    public boolean isSelectedRestart() {
        return isSelected(0);
    }

    public boolean isSelectedExit() {
        return isSelected(1);
    }
}