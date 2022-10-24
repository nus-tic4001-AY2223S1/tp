package seedu.duke;

import seedu.duke.book.*;
import seedu.duke.command.Command;
import seedu.duke.exception.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UI;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static File file;
    private UI ui;
    private static ArrayList<Book> bookList;
    private Storage storage;

    public Duke(String filename) {
        String home = System.getProperty("user.home");
        java.nio.file.Path directory = java.nio.file.Paths.get(home, "Duke");
        java.nio.file.Path pathFile = java.nio.file.Paths.get(home, "Duke", filename + ".txt");
        file = pathFile.toFile();

        ui = new UI();
        ui.showWelcome();

        bookList = new ArrayList<>();
        storage = new Storage(directory, pathFile, bookList);

        Parser.parseBookFromFile(pathFile, storage, bookList);
    }

    public void run() {
        while (!Command.isExit) {
            try {
                String userInput = ui.readUserInput();
                ui.showLine();
                Command c = Parser.parseUserInput(userInput);
                c.execute(userInput, bookList, storage, file);
                c.setIsExit();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nTo begin, enter your filename: \n");

        Scanner in = new Scanner(System.in);
        String filename = in.nextLine();

        System.out.println("__________________________________________________");

        new Duke(filename).run();
    }
}
