package LDTS.SpaceEscape.Model.menu;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class TextReader extends Menu {
    private final ArrayList<String> text;

    public TextReader(String text) throws FileNotFoundException {
        this.text = sortText(readFile(text));
    }

    public int getSize() {
        return text.size();
    }

    public String getLine(int i) {
        return text.get(i);
    }

    private ArrayList<String> readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        ArrayList<String> text = new ArrayList<>();

        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            text.add(scanner.nextLine());
        }
        return text;
    }

    public ArrayList<String> sortText(ArrayList<String> text) {
        return text;
    }
}
