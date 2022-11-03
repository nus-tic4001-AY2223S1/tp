package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BorrowCommandTest {
    ArrayList<Book> bookList = new ArrayList<>();

    String s = "Title: Clean Code | Author: Robert C. Martin |" +
            " Edition: 2nd edition | Published: 2012 |" +
            " Category: Software Engineering | " +
            "On-shelf: true | Borrower: Benjamin";

    Storage storage = new Storage(bookList);

    @Test
    void areDetailsCorrect() {
        storage.addBook(s);

        String title1 = "Clean Code";
        String title2 = "Refactoring";
        BorrowCommand command = new BorrowCommand();

        assertEquals(true, command.areDetailsCorrect(bookList, title1));
        assertEquals(false, command.areDetailsCorrect(bookList, title2));
    }
}
