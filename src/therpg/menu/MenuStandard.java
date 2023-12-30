package therpg.menu;

import therpg.menu.option.OptionFactory;
import therpg.Main;

public class MenuStandard extends MenuAbstract{

    public MenuStandard(){
        this.name = "standard";
    }

    @Override
    public void display() {
        System.out.println("--------------------------------------------");
        System.out.println(Main.player.getName());
        System.out.print("HP: " + Main.player.getHp());
        System.out.println(" | (" + Main.player.pos_x + ", " + Main.player.pos_y + ") global coordinates");
        System.out.println("--------------------------------------------");
    }

    @Override
    public void initOptions() {
        OptionFactory optionFactory = new OptionFactory();
        this.options.add(optionFactory.getOption("seeExampleMap"));
        this.options.add(optionFactory.getOption("exit"));
    }
}
