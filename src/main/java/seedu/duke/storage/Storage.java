package seedu.duke.storage;

import seedu.duke.book.Book;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Storage {
    private Path myDirectory;
    private Path myPathFile;
    private ArrayList<Book> myBookList;

    public Storage(Path directory, Path pathFile, ArrayList<Book> myBookList) {
        myDirectory = directory;
        myPathFile = pathFile;
        this.myBookList = myBookList;

        try {
            File dir = new File(String.valueOf(directory));

            if (!dir.exists()) {
                dir.mkdirs();
            }

            Files.createFile(pathFile);
        } catch (IOException e) {
            System.out.println("    Your chosen filename exists at " +
                    e.getMessage() + ".\n    I will proceed to use this as the " +
                    "working file and update accordingly.\n");
        }
    }

    public void loadBookFromFile(String s) {
        String[] splitString = s.split(" \\| ");

        String title = splitString[0].substring(7);
        String author = splitString[1].substring(8);
        String edition = splitString[2].substring(9);
        String published = splitString[3].substring(11);
        int totalCopy = Integer.parseInt(splitString[4].substring(15));
        int onShelf = Integer.parseInt(splitString[4].substring(10, splitString[4].indexOf(" of")));
        String category = splitString[5].substring(10);

        myBookList.add(new Book(title, author, edition, published, totalCopy, onShelf, category));
    }
}
