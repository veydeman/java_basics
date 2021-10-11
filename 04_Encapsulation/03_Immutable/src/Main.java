public class Main {
    public static void main(String[] args) {

        Book book = new Book("War and Peace", "Tolstoy", 99999999, 84853234);

        System.out.println(book.getAuthor());
        System.out.println(book.getName());
        System.out.println(book.getIsbn());
        System.out.println(book.getPageQuantity());
    }
}
