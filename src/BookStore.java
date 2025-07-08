import java.util.List;

public class BookStore {
    private Inventory inventory;

    public BookStore() {
        this.inventory = new Inventory();
    }
    public void addBook(Book book) {
        inventory.addBook(book);
        System.out.println("Quantum book store: ");
        System.out.println("Added book: " + book.getIsbn() + " - " + book.getTitle());
    }
    
    public void removeBook(String isbn) throws BookNotFound {
        Book book = inventory.getBook(isbn);
        if (book == null) {
            throw new BookNotFound("Book not found");
        }
        inventory.removeBook(isbn);
        System.out.println("Quantum book store: ");
        System.out.println("Removed book: " + isbn + " - " + book.getTitle());
    }
    
    public List<Book> removeOutdatedBooks(int years) {
        List<Book> outdatedBooks = inventory.getOutdatedBooks(years);
        
        for (Book book : outdatedBooks) {
            inventory.removeBook(book.getIsbn());
            System.out.println("Quantum book store: ");
            System.out.println("Removed outdated book: " + book.getIsbn() + " - " + book.getTitle());
        }
        
        return outdatedBooks;
    }
    
    public double buyBook(String isbn, int quantity, String email, String address) throws BookNotFound, BookOutOfStock , ShowCaseBookNotForSale {
        Book book = inventory.getBook(isbn);
        if (book == null) {
            throw new BookNotFound("Book not found");
        }
        if (book instanceof ShowcaseBook) {
            throw new ShowCaseBookNotForSale("Showcase books are not for sale");
        }
        if (quantity <= 0) {
            throw new BookOutOfStock("Invalid quantity");
        }
        String title = book.getTitle();
        double totalAmount = book.getPrice() * quantity;
        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            if (paperBook.getStock() < quantity) {
                throw new RuntimeException("Insufficient stock");
            }
            paperBook.reduceStock(quantity);
            ShippingService.shipBook(title, address, quantity);
        } else if (book instanceof Ebook) {
            MailService.sendEmail(title, email);
        }
         System.out.println("Quantum book store: ");
         System.out.println("Purchase completed. Amount paid: EGP" + String.format("%.2f", totalAmount));
        return totalAmount;
    }
    public Book getBook(String isbn) {
        return inventory.getBook(isbn);
    }
}
