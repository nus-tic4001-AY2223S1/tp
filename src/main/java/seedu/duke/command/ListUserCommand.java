package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>ListUserCommand</code> allows the user to see all the books that he
 * currently borrowed.
 */
public class ListUserCommand extends Command {
    /**
     * Prints out all the books in the library to the CLI. These books are
     * currently borrowed by and specific to the user.
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
        if (didUserBorrow(user, bookList)) {
            System.out.println("Here are the books that you borrowed:");
            for (int i = 0; i < bookList.size(); i++) {
                if (user.equals(bookList.get(i).getBorrower())) {
                    System.out.println("\n" + bookList.get(i));
                }
            }
        } else {
            throw new DukeException("Your account is clear. No books were borrowed.");
        }
    }

    /**
     * Checks whether the requested book is borrowed by the current user.
     *
     * @param user username (case-sensitive) of the current user.
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     */
    public boolean didUserBorrow (String user, ArrayList<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            if (user.equals(bookList.get(i).getBorrower())) {
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
