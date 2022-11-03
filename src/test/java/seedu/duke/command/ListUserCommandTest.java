package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ListUserCommandTest {
    ArrayList<Book> bookList = new ArrayList<>();

    String s = "Title: Clean Code | Author: Robert C. Martin |" +
            " Edition: 2nd edition | Published: 2012 |" +
            " Category: Software Engineering | " +
            "On-shelf: true | Borrower: Benjamin";

    Storage storage = new Storage(bookList);

    @Test
    void didUserBorrow() {
        storage.addBook(s);

        String user1 = "Benjamin";
        String user2 = "Brent";
        ListUserCommand command = new ListUserCommand();

        assertEquals(true, command.didUserBorrow(user1, bookList));
        assertEquals(false, command.didUserBorrow(user2, bookList));
    }
}
