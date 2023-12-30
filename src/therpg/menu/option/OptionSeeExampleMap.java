package therpg.menu.option;

import java.util.Scanner;
import therpg.Main;
import therpg.character.Player;
import therpg.map.ExampleMap;
import therpg.menu.MenuMap;
import therpg.menu.MenuStandard;

public class OptionSeeExampleMap extends OptionAbstract {

    public OptionSeeExampleMap(){
        this.name = "seeExampleMap";
        this.label = "See example map";
    }

    @Override
    public void execute() {
        try {
            Main.currentMap = new ExampleMap();
            Main.currentMap.create();

            Main.stackMenu.push(Main.currentMenu);
            Main.currentMenu = new MenuMap();
        } catch (Exception ex) {
            Main.error = ex.getMessage();
        }
    }
}