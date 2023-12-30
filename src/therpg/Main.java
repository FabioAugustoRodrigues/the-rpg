package therpg;

import java.util.Scanner;
import java.util.Stack;
import therpg.character.Player;
import therpg.map.MapAbstract;
import therpg.menu.MenuAbstract;
import therpg.menu.MenuFactory;

public class Main {

    public static Player player;
    public static MapAbstract currentMap;
    public static String error = "";
    public static MenuAbstract currentMenu;
    public static Stack<MenuAbstract> stackMenu = new Stack();
    public static boolean isGameOver = false;

    public static Main engine;

    public static void clear(){
        for (int i = 0; i < 100; i++){
            System.out.println("\n");
        }
    }

    public void displayMenu(){
        currentMenu.display();
        for (int i = 0; i < currentMenu.getOptions().size(); i++){
            System.out.println("[" + (i + 1) + "] " + currentMenu.getOptions().get(i).getLabel());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main.engine = new Main();
        MenuFactory menuFactory = new MenuFactory();
        Main.currentMenu = menuFactory.getMenu("start");

        try{
            while (!Main.isGameOver){
                System.out.println(Main.error);
                Main.error = "";
                System.out.println();
                engine.displayMenu();
                System.out.print("-> ");
                Main.currentMenu.choose(scanner.nextInt());
                Main.clear();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}