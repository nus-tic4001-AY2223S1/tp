package seedu.duke.book;

import org.junit.jupiter.api.Test;
import seedu.duke.storage.Storage;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    ArrayList<Book> bookList = new ArrayList<>();

    String s = "Title: Clean Code | Author: Robert C. Martin |" +
            " Edition: 2nd edition | Published: 2012 |" +
            " Category: Software Engineering | " +
            "On-shelf: true | Borrower: -";

    Storage storage = new Storage(bookList);

    @Test
    void testToString() {
        storage.addBook(s);

        assertEquals("Title: Clean Code\nAuthor: Robert C. Martin\n" +
                "Edition: 2nd edition\nPublished: 2012\n" +
                "Category: Software Engineering\nOn-shelf: true\n" +
                "Borrower: -", bookList.get(0).toString());
    }

    @Test
    void isOnShelf() {
        storage.addBook(s);

        assertEquals(true, bookList.get(0).isOnShelf());
    }
}
