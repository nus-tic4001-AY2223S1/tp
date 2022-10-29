package seedu.duke.ui;

import java.util.Scanner;

public class UI {
    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("\nHello from\n" + logo);
    }

    public String readUserInput() {
        Scanner in = new Scanner(System.in);

        return in.nextLine();
    }

    public void showLine() {
        System.out.println("__________________________________________________________" +
                "__________________________________________");
    }
}

