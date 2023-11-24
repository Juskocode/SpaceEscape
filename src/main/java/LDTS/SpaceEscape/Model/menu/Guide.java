package LDTS.SpaceEscape.struct.menu;

import java.io.FileNotFoundException;

public class Guide extends TextReader {
    public Guide() throws FileNotFoundException {
        super("src/main/resources/text/guide.txt");
    }
}
