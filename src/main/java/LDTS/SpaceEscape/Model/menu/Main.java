package LDTS.SpaceEscape.struct.menu;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;

public class Main extends Menu {
    String funfact;

    public Main() throws IOException {
        fillFunFacts();
        this.options = Arrays.asList("Start", "Leaderboard", "Instructions", "Exit");
    }

    private void fillFunFacts() throws IOException {
        Path path_ = Path.of("src/main/resources/text/funfacts.txt");
        String contents = Files.readString(path_);
        String[] funfacts = contents.split("###");
        Random random = new Random();
        int randomValue = random.nextInt(funfacts.length);
        this.funfact = funfacts[randomValue];
    }

    public boolean isSelectedExit() {
        return isSelected(3);
    }

    public boolean isSelectedInstructions() {
        return isSelected(2);
    }

    public boolean isSelectedStart() {
        return isSelected(0);
    }

    public boolean isSelectedLeaderboard() {
        return isSelected(1);
    }

    public String getFunfact() {
        return funfact;
    }
}
