package seedu.duke.book;

public class Book {
    protected String title;
    protected String author;
    protected String edition;
    protected String published;
    protected int totalCopy;
    protected int onShelf;
    protected String category;

    public Book(String title, String author, String edition, String published, int totalCopy, int onShelf, String category) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.published = published;
        this.totalCopy = totalCopy;
        this.onShelf = onShelf;
        this.category = category;
    }

    @Override
    public String toString() {
        return " Title: " + title + "\n" + "         Author: " + author + "\n" + "         Edition: " + edition + "\n" + "         Published: " +
                published + "\n" + "         On-shelf: " + onShelf + " of " + totalCopy + "\n" + "         Category: " + category + "\n";
    }
}

