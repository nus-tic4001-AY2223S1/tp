package seedu.duke.parser;

import seedu.duke.book.Book;
import seedu.duke.command.Command;
import seedu.duke.command.ExitCommand;
import seedu.duke.command.ListCommand;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Parser {
    public static void  parseBookFromFile(Path pathFile, Storage storage, ArrayList<Book> bookList) {
        try {
            File f = pathFile.toFile();
            Scanner s = new Scanner(f);
            String input = "";
            Boolean isEmpty = false;

            while (s.hasNext()) {
                isEmpty = true;
                String line = s.nextLine();

                if (line.length() == 0) {
                    storage.loadBookFromFile(input);
                    input = "";
                } else {
                    input = input + line + " | ";
                }
            }

            if (isEmpty) {
                storage.loadBookFromFile(input);

                System.out.println("    There are " + bookList.size() +
                        " different book(s) in the library at the moment.\n");
            } else {
                System.out.println("    There are no books available in the library at the moment.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public static Command parseUserInput(String userInput) throws DukeException {
        String[] firstWord = userInput.split(" ", 2);

        if (firstWord[0] == "bye") {
            return new ExitCommand();
        } else if (firstWord[0] == "list") {
            return new ListCommand();
        } else {
            throw new DukeException("\u2639 " + "OOPS!!! I'm sorry, " +
                    "but I don't know what that means :-(");
        }
    }
}

