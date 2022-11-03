package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>ReturnCommand</code> class removes the link between the user and the
 * book that is being returned.
 */
public class ReturnCommand extends Command {
    /**
     * Unlinks the subject book from the user.
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

        if (areDetailsCorrect(bookList, title, user)) {
            for (int i = 0; i < bookList.size(); i++) {
                if (title.equalsIgnoreCase(bookList.get(i).getTitle())) {
                    bookIndex = i;
                }
            }

            if (!bookList.get(bookIndex).isOnShelf()) {
                bookList.get(bookIndex).setOnShelf(true);
                bookList.get(bookIndex).setBorrower("");
                storage.updateLibrary(bookList, file);

                System.out.println("The book has been returned to the library.");
            } else {
                throw new DukeException("The book is still on the shelve! Please check your entry.");
            }
        } else {
            throw new DukeException("Either the library does not have this book or you are not " +
                    "the current borrower! Please check your entry.");
        }
    }

    /**
     * Checks if the requested book exists in the library and the current user is the borrower.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param title title of the book that is being requested or borrowed.
     */
    public boolean areDetailsCorrect(ArrayList<Book> bookList, String title, String user) {
        for (int i = 0; i < bookList.size(); i++) {
            if (title.equalsIgnoreCase(bookList.get(i).getTitle()) &&
                    user.equals(bookList.get(i).getBorrower())) {
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
