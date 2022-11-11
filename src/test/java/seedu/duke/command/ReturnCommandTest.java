package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReturnCommandTest {
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
        String borrower1 = "Benjamin";
        String borrower2 = "Brent";
        ReturnCommand command = new ReturnCommand();

        assertEquals(true, command.isInLibrary(bookList, title1));
        assertEquals(false, command.isInLibrary(bookList, title2));
    }
}
