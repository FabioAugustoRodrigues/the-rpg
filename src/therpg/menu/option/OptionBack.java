package therpg.menu.option;

import therpg.Main;

public class OptionBack extends OptionAbstract{

    public OptionBack(){
        this.name = "back";
        this.label = "Back";
    }

    @Override
    public void execute() {
        Main.currentMenu = Main.stackMenu.pop();
    }

}