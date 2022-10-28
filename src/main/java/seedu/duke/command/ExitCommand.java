package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class ExitCommand extends Command{
    @Override
    public void execute(String userInput, ArrayList<Book> bookList, Storage storage, File file) {
        System.out.println("    Bye. Hope to see you again soon!");
    }

    @Override
    public boolean setIsExit() {
        return isExit = true;
    }
}
