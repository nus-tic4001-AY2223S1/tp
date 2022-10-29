package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class ListUserCommand extends Command {
    @Override
    public void execute(String userInput, ArrayList<Book> bookList, Storage storage, File file) throws DukeException {
//        if (bookList.isEmpty()) {
//            throw new DukeException("    There are no books available in your inventory at the moment.");
//        } else {
//            System.out.println("    Here are the book(s) in the inventory:");
//            for (int i = 0; i < bookList.size(); i++) {
//                Book book = bookList.get(i);
//                if (book.onShelf == 0) {
//                    System.out.println("      " + bookList.get(i));
//                }
//            }
//        }
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
