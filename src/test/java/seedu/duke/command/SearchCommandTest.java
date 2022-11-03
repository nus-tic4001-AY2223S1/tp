package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchCommandTest {
    ArrayList<Book> bookList = new ArrayList<>();

    String s = "Title: Clean Code | Author: Robert C. Martin |" +
            " Edition: 2nd edition | Published: 2012 |" +
            " Category: Software Engineering | " +
            "On-shelf: true | Borrower: Benjamin";

    Storage storage = new Storage(bookList);

    @Test
    void hasMatchingTitle() {
        storage.addBook(s);

        String titleKeyword1 = "Code";
        String titleKeyword2 = "Finite";
        SearchCommand command = new SearchCommand();

        assertEquals(true, command.hasMatchingTitle(bookList, titleKeyword1));
        assertEquals(false, command.hasMatchingTitle(bookList, titleKeyword2));
    }

    @Test
    void hasMatchingAuthor() {
        storage.addBook(s);

        String authorKeyword1 = "Martin";
        String authorKeyword2 = "Reddy";
        SearchCommand command = new SearchCommand();

        assertEquals(true, command.hasMatchingAuthor(bookList, authorKeyword1));
        assertEquals(false, command.hasMatchingAuthor(bookList, authorKeyword2));
    }

    @Test
    void hasMatchingCategory() {
        storage.addBook(s);

        String categoryKeyword1 = "Software";
        String categoryKeyword2 = "Civil";
        SearchCommand command = new SearchCommand();

        assertEquals(true, command.hasMatchingCategory(bookList, categoryKeyword1));
        assertEquals(false, command.hasMatchingCategory(bookList, categoryKeyword2));
    }
}
