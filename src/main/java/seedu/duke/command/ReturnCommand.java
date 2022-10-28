package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class ReturnCommand extends Command {
    @Override
    public void execute(String userInput, ArrayList<Book> bookList, Storage storage, File file) throws DukeException {
        if (bookList.isEmpty()) {
            throw new DukeException("    There are no books available in the library at the moment.");
        }
        int n = userInput.indexOf('/');
        String marker = userInput.substring(n, n+2).trim();

        if (marker.equals("t")) {
            String title = userInput.substring(n+3);
            for (int i = 0; i < bookList.size(); i++) {
                Book book = bookList.get(i);
                if (book.title.equalsIgnoreCase(title)) {
                    bookList.get(i).onShelf = 1;
                }
            }
        }
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
