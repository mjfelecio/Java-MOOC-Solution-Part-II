package mooc;

import mooc.logic.ApplicationLogic;
import mooc.ui.UserInterface;
import mooc.ui.TextInterface;

public class Main {

    public static void main(String[] args) {
        UserInterface kali = new TextInterface();
        ApplicationLogic app = new ApplicationLogic(kali);
        app.execute(3);
    }
}
