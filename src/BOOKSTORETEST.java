import java.util.List;

public class BOOKSTORETEST {
    private BookStore bookStore;
    
    public BOOKSTORETEST() {
        bookStore = new BookStore();
        setupInventory();
    }
    
    private void setupInventory() {
        bookStore.addBook(new PaperBook("ISBN001", "Java Programming", "John Doe", 2020, 299.99, 10));
        bookStore.addBook(new PaperBook("ISBN002", "Low Stock Book", "Jane Smith", 2021, 150.99, 2));
        bookStore.addBook(new Ebook("ISBN003", "Python Guide", "Bob Wilson", 2022, 1990.99, "PDF"));
        bookStore.addBook(new Ebook("ISBN004", "JavaScript Basics", "Alice Brown", 2023, 2450.99, "EPUB"));
        bookStore.addBook(new ShowcaseBook("ISBN005", "Demo Book", "Demo Author", 2023, 0.0));
        bookStore.addBook(new PaperBook("ISBN006", "Old Book", "Old Author", 2010, 129.99, 5));
    }
    
    public void testBuyingEBook() {
        System.out.println("\n=== Test 1: Buying an EBook ===");
        try {
            double amount = bookStore.buyBook("ISBN003", 1, "customer@email.com", "123 Main St");
            System.out.println("EBook purchase successful: EGP" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("EBook purchase failed: " + e.getMessage());
        }
    }
    
    public void testBuyingPaperBookWithEnoughStock() {
        System.out.println("\n=== Test 2: Buying Paper Book with Sufficient Stock ===");
        try {
            Book book = bookStore.getBook("ISBN001");
            int initialStock = ((PaperBook) book).getStock();
            System.out.println("Initial stock: " + initialStock);
            
            double amount = bookStore.buyBook("ISBN001", 3, "customer@email.com", "123 Main St");
            
            int newStock = ((PaperBook) book).getStock();
            System.out.println("Stock after purchase: " + newStock);
            System.out.println("Paper book purchase successful: EGP" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Paper book purchase failed: " + e.getMessage());
        }
    }
    
    public void testBuyingPaperBookWithInsufficientStock() {
        System.out.println("\n=== Test 3: Buying Paper Book with Insufficient Stock ===");
        try {
            Book book = bookStore.getBook("ISBN002");
            int availableStock = ((PaperBook) book).getStock();
            System.out.println("Available stock: " + availableStock);
            System.out.println("Attempting to buy " + (availableStock + 1) + " copies...");
            
            double amount = bookStore.buyBook("ISBN002", availableStock + 1, "customer@email.com", "123 Main St");
            System.out.println("Should have failed but didn't: EGP" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Expected error for insufficient stock: " + e.getMessage());
        }
    }
    
    public void testBuyingShowcaseBook() {
        System.out.println("\n=== Test 4: Buying Showcase/Demo Book ===");
        try {
            double amount = bookStore.buyBook("ISBN005", 1, "customer@email.com", "123 Main St");
            System.out.println("Should have failed but didn't: EGP" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Expected error for showcase book: " + e.getMessage());
        }
    }
    
    public void testBuyingNonExistentBook() {
        System.out.println("\n=== Test 5: Buying Non-Existent Book ===");
        try {
            double amount = bookStore.buyBook("ISBN999", 1, "customer@email.com", "123 Main St");
            System.out.println("Should have failed but didn't: EGP" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Expected error for non-existent book: " + e.getMessage());
        }
    }
    
    public void testRemovingBook() {
        System.out.println("\n=== Test 6: Removing a Book ===");
        try {
            bookStore.addBook(new PaperBook("ISBN007", "Book to Remove", "Test Author", 2023, 9.99, 1));
            Book book = bookStore.getBook("ISBN007");
            if (book != null) {
                System.out.println("Book exists: " + book.getTitle());
            }
            bookStore.removeBook("ISBN007");
            Book removedBook = bookStore.getBook("ISBN007");
            if (removedBook == null) {
                System.out.println("Book successfully removed");
            } else {
                System.out.println("Book still exists after removal");
            }
        } catch (Exception e) {
            System.out.println("Error removing book: " + e.getMessage());
        }
    }
    
    public void testRemovingNonExistentBook() {
        System.out.println("\n=== Test 7: Removing Non-Existent Book ===");
        try {
            bookStore.removeBook("ISBN888");
            System.out.println("Should have failed but didn't");
        } catch (Exception e) {
            System.out.println("Expected error for non-existent book: " + e.getMessage());
        }
    }
    
    public void testRemovingOutdatedBooks() {
        System.out.println("\n=== Test 8: Removing Outdated Books ===");
        try {
            System.out.println("Removing books older than 10 years...");
            List<Book> removedBooks = bookStore.removeOutdatedBooks(10);
            
            if (removedBooks.isEmpty()) {
                System.out.println("No outdated books found");
            } else {
                System.out.println(" Removed " + removedBooks.size() + " outdated books:");
                for (Book book : removedBooks) {
                    System.out.println("  - " + book.getTitle() + " (Year: " + book.getYearOfPublication() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("✗ Error removing outdated books: " + e.getMessage());
        }
    }
    
    public void testInvalidQuantity() {
        System.out.println("\n=== Test 9: Invalid Quantity ===");
        try {
            double amount = bookStore.buyBook("ISBN003", 0, "customer@email.com", "123 Main St");
            System.out.println("Should have failed but didn't: EGP" + String.format("%.2f", amount));
        } catch (Exception e) {
            System.out.println("Expected error for invalid quantity: " + e.getMessage());
        }
    }
    
    public void runAllTests() {
        System.out.println("Starting Quantum Bookstore Tests...");
        testBuyingEBook();
        testBuyingPaperBookWithEnoughStock();
        testBuyingPaperBookWithInsufficientStock();
        testBuyingShowcaseBook();
        testBuyingNonExistentBook();
        testRemovingBook();
        testRemovingNonExistentBook();
        testRemovingOutdatedBooks();
        testInvalidQuantity();
        System.out.println("\n=== All Tests Completed ===");
    }
    public static void main(String[] args) {
        BOOKSTORETEST test = new BOOKSTORETEST();
        test.runAllTests();
    }

}
