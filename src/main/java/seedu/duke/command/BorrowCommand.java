package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>BorrowCommand</code> class creates a link between the user and the
 * book that is being requested or borrowed.
 */
public class BorrowCommand extends Command {
    /**
     * Links the requested or borrowed book to the user.
     *
     * @param user username (case-sensitive) of the current user.
     * @param userInput query typed in by the user.
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param storage class that ensures consistency of the record.
     * @param file represents the txt file that keeps the library record.
     */
    @Override
    public void execute(String user, String userInput,
                        ArrayList<Book> bookList, Storage storage,
                        File file) throws DukeException {
        String title = userInput.split("/")[1].trim();
        int bookIndex = 0;

        if (areDetailsCorrect(bookList, title)) {
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
                throw new DukeException("The book was borrowed and has not been returned yet. " +
                        "For now, you may reserve the book.");
            }

        } else {
            throw new DukeException("The book is not available in the library yet. " +
                    "\nYou may check what's in the library using the list/library or l/l command.");
        }
    }

    /**
     * Checks if the requested book exists in the library.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param title title of the book that is being requested or borrowed.
     */
    public boolean areDetailsCorrect (ArrayList<Book> bookList, String title) {
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

