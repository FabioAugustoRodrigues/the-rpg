package therpg.menu.option;

import java.util.Scanner;
import therpg.Main;

public class OptionMoveAroundMap extends OptionAbstract{

    public OptionMoveAroundMap(){
        this.name = "moveAroundMap";
        this.label = "Move around the map";
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        Main.currentMap.moveToPosition(Main.player.pos_x, Main.player.pos_y, Main.player.pos_x, Main.player.pos_y);

        boolean loop = true;

        while (loop){
            System.out.println("[W] UP | [A] LEFT | [S] DOWN | [D] RIGHT | [0] EXIT");
            System.out.print("-> ");
            char direction = scanner.next().toUpperCase().charAt(0);

            switch (direction){
                case 'W':
                    if (Main.currentMap.checkPosition(Main.player.pos_x, Main.player.pos_y-1)){
                        Main.currentMap.moveToPosition(Main.player.pos_x, Main.player.pos_y, Main.player.pos_x, --Main.player.pos_y);
                    }
                    break;
                case 'A':
                    if (Main.currentMap.checkPosition(Main.player.pos_x-1, Main.player.pos_y)){
                        Main.currentMap.moveToPosition(Main.player.pos_x, Main.player.pos_y, --Main.player.pos_x, Main.player.pos_y);
                    }
                    break;
                case 'S':
                    if (Main.currentMap.checkPosition(Main.player.pos_x, Main.player.pos_y+1)){
                        Main.currentMap.moveToPosition(Main.player.pos_x, Main.player.pos_y, Main.player.pos_x, ++Main.player.pos_y);
                    }
                    break;
                case 'D':
                    if (Main.currentMap.checkPosition(Main.player.pos_x+1, Main.player.pos_y)){
                        Main.currentMap.moveToPosition(Main.player.pos_x, Main.player.pos_y, ++Main.player.pos_x, Main.player.pos_y);
                    }
                    break;
                case '0':
                    loop = false;
            }

            if (!loop){break;}

            Main.clear();
            Main.currentMap.show();
        }
    }
}
