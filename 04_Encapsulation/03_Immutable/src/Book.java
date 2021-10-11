public class Book {

    private final String name;
    private final String author;
    private final int pageQuantity;
    private final int isbn;

    public Book(String name, String author, int pageQuantity, int isbn) {
        this.name = name;
        this.author = author;
        this.pageQuantity = pageQuantity;
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageQuantity() {
        return pageQuantity;
    }

    public int getIsbn() {
        return isbn;
    }
}
