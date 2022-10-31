package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReturnCommandTest {
    ArrayList<Book> bookList = new ArrayList<>();

    String s = "Title: Clean Code | Author: Robert C. Martin |" +
            " Edition: 2nd edition | Published: 2012 |" +
            " Category: Software Engineering | " +
            "On-shelf: true | Borrower: Benjamin";

    Storage storage = new Storage(bookList);

    @Test
    void isAvailable() {
        storage.addBook(s);

        String title1 = "Clean Code";
        String title2 = "Refactoring";
        ReturnCommand command = new ReturnCommand();

        assertEquals(true, command.isAvailable(bookList, title1));
        assertEquals(false, command.isAvailable(bookList, title2));
    }
}
