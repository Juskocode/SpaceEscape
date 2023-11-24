package LDTS.SpaceEscape.Controller.menu;

import com.googlecode.lanterna.input.KeyStroke;
import LDTS.SpaceEscape.App;
import LDTS.SpaceEscape.struct.menu.GameOver;
import static LDTS.SpaceEscape.state.AppState.GAME_STATE;
import static LDTS.SpaceEscape.state.AppState.MENU_STATE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class GameOverController extends MenuController<GameOver> {

    public GameOverController(GameOver model) {
        super(model);
    }

    @Override
    public void optionSelected(App game) throws IOException {
        if (getModel().getUsername().trim().length() > 0) updateLeaderboard();
        if (getModel().isSelectedRestart()) game.setState(GAME_STATE);
        if (getModel().isSelectedExit()) game.setState(MENU_STATE);
    }

    @Override
    public void charSelected(KeyStroke key) {
        if (isLetter(key) || isNumber(key) || isSpace(key)) {
            getModel().addChar(key.getCharacter());
        }
    }

    @Override
    public void escapePressed(App game) throws IOException {
        game.setState(MENU_STATE);
    }

    @Override
    public void backspacePressed(App game) {
        getModel().removeChar();
    }

    public void updateLeaderboard() throws IOException {
        File leaderboard = new File("src/main/resources/text/leaderboard.txt");
        Scanner scanner = new Scanner(leaderboard);
        ArrayList<Integer> scores = new ArrayList<>();
        ArrayList<String> usernames = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split("-");
            scores.add(Integer.parseInt(parts[0].trim()));
            usernames.add(parts[1].trim());
        }

        if (scores.size() < 5) {
            FileWriter writer = new FileWriter(leaderboard, true);
            writer.write(getModel().getScore() + " - " + getModel().getUsername() + "\n");
            writer.close();
            return;
        }

        int minimumScore = Collections.min(scores);
        int minimumScoreIndex = scores.indexOf(minimumScore);

        if (getModel().getScore() > minimumScore) {
            scores.set(minimumScoreIndex, getModel().getScore());
            usernames.set(minimumScoreIndex, getModel().getUsername());
            FileWriter writer = new FileWriter(leaderboard);
            for (int i = 0; i < scores.size(); i++) {
                writer.write(scores.get(i) + " - " + usernames.get(i) + "\n");
            }
            writer.close();
        }
    }

    private boolean isNumber(KeyStroke key) {
        return (key.getCharacter() >= '0' && key.getCharacter() <= '9');
    }

    private boolean isLetter(KeyStroke key) {
        return (key.getCharacter() >= 'a' && key.getCharacter() <= 'z') || (key.getCharacter() >= 'A' && key.getCharacter() <= 'Z');
    }

    private boolean isSpace(KeyStroke key) {
        return key.getCharacter() == ' ';
    }
}