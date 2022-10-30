package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class BorrowCommand extends Command {
    @Override
    public void execute(String user, String userInput,
                        ArrayList<Book> bookList, Storage storage,
                        File file) throws DukeException {
        String title = userInput.split("/")[1].trim();
        int bookIndex = 0;

        if (isAvailable(bookList, title)) {
            for (int i = 0; i < bookList.size(); i++) {
                if (title.equalsIgnoreCase(bookList.get(i).getTitle())) {
                    bookIndex = i;
                }
            }

            if (bookList.get(bookIndex).isOnShelf()) {
                bookList.get(bookIndex).setOnShelf(false);
                bookList.get(bookIndex).setBorrower(user);
                storage.updateLibrary(bookList, file);

                System.out.println("The book has been added to your account.");
            } else {
                throw new DukeException("The book was borrowed and has not been returned yet.");
            }

        } else {
            throw new DukeException("That book is not available in the library yet. " +
                    "You may check what's in the \nlibrary using the list, list /l, " +
                    "or list /library command.");
        }
    }

    public boolean isAvailable (ArrayList<Book> bookList, String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (title.equalsIgnoreCase(bookList.get(i).getTitle())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
