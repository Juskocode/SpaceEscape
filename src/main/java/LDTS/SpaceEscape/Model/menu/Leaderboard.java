package LDTS.SpaceEscape.struct.menu;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Leaderboard extends TextReader {

    public Leaderboard() throws FileNotFoundException {
        super("src/main/resources/text/leaderboard.txt");
    }

    @Override
    public ArrayList<String> sortText(ArrayList<String> leaderboard) {
        leaderboard.sort((s1, s2) -> {
            String[] s1Split = s1.split(" ");
            String[] s2Split = s2.split(" ");
            return Integer.parseInt(s2Split[0]) - Integer.parseInt(s1Split[0]);
        });
        return leaderboard;
    }
}
