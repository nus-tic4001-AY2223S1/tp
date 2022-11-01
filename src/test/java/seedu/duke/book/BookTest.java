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
            "On-shelf: true | Borrower: Benjamin";

    Storage storage = new Storage(bookList);

    @Test
    void getTitle() {
        storage.addBook(s);

        assertEquals("Clean Code", bookList.get(0).getTitle());
    }

    @Test
    void getAuthor() {
        storage.addBook(s);

        assertEquals("Robert C. Martin", bookList.get(0).getAuthor());
    }

    @Test
    void getCategory() {
        storage.addBook(s);

        assertEquals("Software Engineering", bookList.get(0).getCategory());
    }

    @Test
    void isOnShelf() {
        storage.addBook(s);

        assertEquals(true, bookList.get(0).isOnShelf());
    }
    @Test
    void getBorrower() {
        storage.addBook(s);

        assertEquals("Benjamin", bookList.get(0).getBorrower());
    }

    @Test
    void testToString() {
        storage.addBook(s);

        assertEquals("Title: Clean Code\nAuthor: Robert C. Martin\n" +
                "Edition: 2nd edition\nPublished: 2012\n" +
                "Category: Software Engineering\nOn-shelf: true\n" +
                "Borrower: Benjamin", bookList.get(0).toString());
    }
}
