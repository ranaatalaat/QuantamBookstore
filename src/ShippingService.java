public class ShippingService {
    public static void shipBook(String title, String address, int quantity) {
        System.out.println("Sending  the book to this address: " + address);
        System.out.println("Book Title: " + title );
        System.out.println("Book Quantity: " + quantity);
        System.out.println("Book shipped successfully!");
    }
}
