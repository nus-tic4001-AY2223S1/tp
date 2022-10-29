package seedu.duke;

import seedu.duke.book.Book;
import seedu.duke.command.Command;
import seedu.duke.exception.DukeException;
import seedu.duke.parser.Parser;
import seedu.duke.storage.Storage;
import seedu.duke.ui.UI;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    private static File libraryFile;
    private UI ui;
    private ArrayList<Book> bookList;
    private Storage storage;

    public Duke(String user) {
        String home = System.getProperty("user.dir");
        java.nio.file.Path directory = java.nio.file.Paths.get(home,
                "/src/main/java/seedu/duke/");
        java.nio.file.Path pathLibraryFile = java.nio.file.Paths.get(home,
                "/src/main/java/seedu/duke/", "library.txt");
        java.nio.file.Path pathUserFile = java.nio.file.Paths.get(home,
                "/src/main/java/seedu/duke/", user + ".txt");
        libraryFile = pathLibraryFile.toFile();

        if (!libraryFile.exists()) {
            System.out.println("\n    The library file does not exists! Please check the file " +
                    "and the path directory.\n");
            System.exit(0);
        }

        ui = new UI();
        ui.showWelcome();

        bookList = new ArrayList<>();
        storage = new Storage(directory, pathUserFile, bookList);
        storage.loadFromFile(pathLibraryFile, bookList);
    }

    public void run() {
        while (!Command.isExit) {
            try {
                String userInput = ui.readUserInput();
                ui.showLine();
                Command c = Parser.parseUserInput(userInput.trim());
                c.execute(userInput, bookList, storage, libraryFile);
                c.setIsExit();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nEnter your username to begin: \n");

        Scanner in = new Scanner(System.in);
        String user = in.nextLine();

        System.out.println("__________________________________________________________" +
                "__________________________________________");

        new Duke(user).run();
    }
}
