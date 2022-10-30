package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class SearchCommand extends Command {
    @Override
    public void execute(String user, String userInput,
                        ArrayList<Book> bookList, Storage storage,
                        File file) throws DukeException {

        String by = userInput.split("/")[1].trim();
        String keyword = userInput.split("/")[2].trim();

        if (by.equalsIgnoreCase("Title")) {
            if (hasMatchingTitle(bookList, keyword)) {
                System.out.println("Here are the book(s) related to your search keyword:");
                printByTitle(bookList, keyword);
            } else {
                throw new DukeException("No related books found. Try other keywords.");
            }
        }

        if (by.equalsIgnoreCase("Author")) {
            if (hasMatchingAuthor(bookList, keyword)) {
                System.out.println("Here are the book(s) related to your search keyword:");
                printByAuthor(bookList, keyword);
            } else {
                throw new DukeException("No related books found. Try other keywords.");
            }
        }

        if (by.equalsIgnoreCase("Category")) {
            if (hasMatchingCategory(bookList, keyword)) {
                System.out.println("Here are the book(s) related to your search keyword:");
                printByCategory(bookList, keyword);
            } else {
                throw new DukeException("No related books found. Try other keywords.");
            }
        }
    }

    public boolean hasMatchingTitle (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMatchingAuthor (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public boolean hasMatchingCategory (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCategory().toLowerCase().contains(keyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void printByTitle (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("\n" + bookList.get(i));
            }
        }
    }

    public void printByAuthor (ArrayList<Book> bookList, String keyword) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("\n" + bookList.get(i));
            }
        }
    }

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
