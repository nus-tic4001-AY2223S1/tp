package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class BorrowCommandTest {
    ArrayList<Book> bookList = new ArrayList<>();

    String s = "Title: Clean Code | Author: Robert C. Martin |" +
            " Edition: 2nd edition | Published: 2012 |" +
            " Category: Software Engineering | " +
            "On-shelf: true | Borrower: [Benjamin]";

    Storage storage = new Storage(bookList);

    @Test
    void isInLibrary() {
        storage.addBook(s);

        String title1 = "Clean Code";
        String title2 = "Refactoring";
        BorrowCommand command = new BorrowCommand();

        assertTrue(command.isInLibrary(bookList, title1));
        assertFalse(command.isInLibrary(bookList, title2));
    }
}
