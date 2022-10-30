package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class ListUserCommand extends Command {
    @Override
    public void execute(String user, String userInput,
                        ArrayList<Book> bookList, Storage storage,
                        File file) throws DukeException {
        if (didUserBorrow(user, bookList)) {
            System.out.println("Here are the books that you borrowed:");
            for (int i = 0; i < bookList.size(); i++) {
                if (user.equals(bookList.get(i).getBorrower())) {
                    System.out.println("\n" + bookList.get(i));
                }
            }
        } else {
            throw new DukeException("Your account is clear. No books were borrowed.");
        }
    }

    public boolean didUserBorrow (String user, ArrayList<Book> bookList) {
        for (int i = 0; i < bookList.size(); i++) {
            if (user.equals(bookList.get(i).getBorrower())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
