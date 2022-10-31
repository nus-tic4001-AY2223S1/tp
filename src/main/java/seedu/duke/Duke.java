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

/**
 * <code>Duke</code> class is the main class of the Librarian application.
 * This includes the <code>main</code> and <code>run</code> methods that
 * taps into the abstracted classes.
 */
public class Duke {
    private String user;
    private static File libraryFile;
    private UI ui;
    private ArrayList<Book> bookList;
    private Storage storage;

    public Duke(String user) {
        this.user = user;
        String home = System.getProperty("user.home");
        java.nio.file.Path pathLibraryFile = java.nio.file.Paths.get(home,
                "/Desktop/librarian/", "library.txt");
        libraryFile = pathLibraryFile.toFile();

        if (!libraryFile.exists()) {
            System.out.println("\nThe library file does not exists! Please check the file " +
                    "and the path directory.\n");
            System.exit(0);
        }

        ui = new UI();
        ui.showWelcome();

        bookList = new ArrayList<>();
        storage = new Storage(bookList);
        storage.loadFromLibrary(pathLibraryFile, bookList);
    }

    public void run() {
        while (!Command.isExit) {
            try {
                String userInput = ui.readUserInput();
                ui.showLine();
                Command c = Parser.parseUserInput(userInput.trim());
                c.execute(user, userInput.trim(), bookList, storage, libraryFile);
                c.setIsExit();
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("\nEnter your username (case sensitive!!!) to begin: \n");

        Scanner in = new Scanner(System.in);
        String user = in.nextLine();

        System.out.println("__________________________________________________________" +
                "__________________________________________");

        new Duke(user).run();
    }
}
