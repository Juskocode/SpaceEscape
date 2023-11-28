package LDTS.SpaceEscape.Model.menu;

import java.io.FileNotFoundException;

public class Guide extends TextReader {
    public Guide() throws FileNotFoundException {
        super("src/main/resources/text/guide.txt");
    }
}
