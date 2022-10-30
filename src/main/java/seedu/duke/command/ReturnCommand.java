package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class ReturnCommand extends Command {
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

            if (!bookList.get(bookIndex).isOnShelf()) {
                bookList.get(bookIndex).setOnShelf(true);
                bookList.get(bookIndex).setBorrower("-");
                storage.updateLibrary(bookList, file);

                System.out.println("The book has been returned to the library.");
            } else {
                throw new DukeException("ERROR: The book entries in the library" +
                        "is inconsistent. Please check!.");
            }

        } else {
            throw new DukeException("ERROR: This inconsistency suggests an error " +
                    "in the library. Please check the details of each book in the " +
                    "library.");
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
