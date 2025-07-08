import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private Map<String, Book> books = new HashMap<>();
    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }
    public Book getBook(String isbn) {
        return books.get(isbn);
    }
    public void removeBook(String isbn) {
        books.remove(isbn);
    }
     public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }
    public List<Book> getOutdatedBooks(int years) {
        List<Book> outdatedBooks = new ArrayList<>();
        int currentYear = 2025;
        for (Book book : books.values()) {
            if (currentYear - book.getYearOfPublication() > years) {
                outdatedBooks.add(book);
            }
        }
        return outdatedBooks;
    }
}
