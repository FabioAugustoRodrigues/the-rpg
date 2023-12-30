package therpg.menu.option;

import java.util.Scanner;
import therpg.Main;
import therpg.character.Player;
import therpg.menu.MenuStandard;

public class OptionStart extends OptionAbstract {

    public OptionStart(){
        this.name = "start";
        this.label = "Start game";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a name: ");
        name = scanner.next();

        Main.player = new Player(name);
        Main.currentMenu = new MenuStandard();
    }
}
