package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>SearchCommand</code> class provides end-users different ways to search
 * the library. Users searching provides keywords which target either the Title,
 * the Author or the Category of the book.
 */
public class SearchCommand extends Command {
    /**
     * Searches the library and prints out the book(s) which matches the
     * user-provided keywords.
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
        String by, keyword;

        try {
            by = userInput.split("/")[1].trim();
            keyword = userInput.split("/")[2].trim();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Refer to documentation for the command syntax: " + e.getMessage());
        }

        if (by.equalsIgnoreCase("Title") || by.equalsIgnoreCase("T")) {
            if (hasMatchingTitle(bookList, keyword)) {
                System.out.println("Here are the book(s) related to your search keyword:");
                printByTitle(bookList, keyword);
            } else {
                throw new DukeException("No related books found. Try other keywords.");
            }
        }

        if (by.equalsIgnoreCase("Author") || by.equalsIgnoreCase("A")) {
            if (hasMatchingAuthor(bookList, keyword)) {
                System.out.println("Here are the book(s) related to your search keyword:");
                printByAuthor(bookList, keyword);
            } else {
                throw new DukeException("No related books found. Try other keywords.");
            }
        }

        if (by.equalsIgnoreCase("Category") || by.equalsIgnoreCase("C")) {
            if (hasMatchingCategory(bookList, keyword)) {
                System.out.println("Here are the book(s) related to your search keyword:");
                printByCategory(bookList, keyword);
            } else {
                throw new DukeException("No related books found. Try other keywords.");
            }
        }
    }

    /**
     * Checks if the keywords appear in the book Title of all the books in the library.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     */
    public boolean hasMatchingTitle (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the keywords appear in the book Author of all the books in the library.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     */
    public boolean hasMatchingAuthor (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the keywords appear in the book Category of all the books in the library.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     */
    public boolean hasMatchingCategory (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Prints out the books in the CLI which contain the user-provided keywords.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     */
    public void printByTitle (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("\n" + bookList.get(i));
            }
        }
    }

    /**
     * Prints out the books in the CLI which contain the user-provided keywords.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     */
    public void printByAuthor (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("\n" + bookList.get(i));
            }
        }
    }

    /**
     * Prints out the books in the CLI which contain the user-provided keywords.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     */
    public void printByCategory (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("\n" + bookList.get(i));
            }
        }
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
