package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public abstract class Command {
    public static boolean isExit = false;

    public abstract void execute(String user, String userInput,
                                 ArrayList<Book> bookList, Storage storage,
                                 File file) throws DukeException;

    public abstract boolean setIsExit();
}

