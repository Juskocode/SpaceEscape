package LDTS.SpaceEscape.Model.menu;

import java.util.List;

import LDTS.SpaceEscape.Controller.sound.SOUNDFX;
import LDTS.SpaceEscape.Controller.sound.SoundState;


public abstract class Menu {
    protected List<String> options;
    protected int option = 0;

    public int getNumberEntries() {
        return this.options.size();
    }

    public String getEntry(int i) {
        return this.options.get(i);
    }

    public void nextOption() {
        SoundState.getInstance().playSoundEffect(SOUNDFX.MENU_SELECT);
        option++;
        if (option > this.options.size() - 1)
            option = 0;
    }

    public void previousOption() {
        SoundState.getInstance().playSoundEffect(SOUNDFX.MENU_SELECT);
        option--;
        if (option < 0)
            option = this.options.size() - 1;
    }

    public boolean isSelected(int i) {
        return option == i;
    }
}
