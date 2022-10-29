package seedu.duke.storage;

import seedu.duke.book.Book;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private ArrayList<Book> bookList;

    public Storage(Path directory, Path pathUserFile, ArrayList<Book> bookList) {
        this.bookList = bookList;

        try {
            File dir = new File(String.valueOf(directory));

            if (!dir.exists()) {
                dir.mkdirs();
            }

            Files.createFile(pathUserFile);
        } catch (IOException e) {
            System.out.println("    Your record exists at " +
                    e.getMessage() + ".\n\n    I will proceed to update" +
                    " your record accordingly.\n");
        }
    }

    public void loadFromFile(Path pathFile, ArrayList<Book> bookList) {
        try {
            File f = pathFile.toFile();
            Scanner s = new Scanner(f);
            String input = "";
            Boolean isEmpty = false;

            while (s.hasNext()) {
                isEmpty = true;
                String line = s.nextLine();

                if (line.length() == 0) {
                    addBook(input);
                    input = "";
                } else {
                    input +=  line + " | ";
                }
            }

            if (isEmpty) {
                addBook(input);

                System.out.println("    There are " + bookList.size() +
                        " different book(s) in the library at the moment.\n");
            } else {
                System.out.println("    There are no books available in the library at the moment.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void addBook(String s) {
        String[] splitString = s.split(" \\| ");

        String title = splitString[0].substring(7);
        String author = splitString[1].substring(8);
        String edition = splitString[2].substring(9);
        String published = splitString[3].substring(11);
        String category = splitString[4].substring(10);
        boolean onShelf = Boolean.parseBoolean(splitString[5].substring(10));
        String borrower = splitString[6].substring(10);

        bookList.add(new Book(title, author, edition, published, category, onShelf, borrower));
    }
}
