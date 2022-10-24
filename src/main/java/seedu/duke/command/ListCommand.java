package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(String userInput, ArrayList<Book> bookList, Storage storage, File file) throws DukeException {
        if (bookList.isEmpty()) {
            throw new DukeException("    There are no books available in the library at the moment.");
        } else {
            System.out.println("    Here are the book(s) in the library:");
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("      " + (i + 1) + "." + (bookList.get(i)));
            }
        }
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
