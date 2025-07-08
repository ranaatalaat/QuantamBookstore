public class PaperBook extends Book {
    private int stock;
    public PaperBook(String isbn, String title,String author, int yearOfPublication, double price, int stock) {
        super(isbn, title,author, yearOfPublication, price);    
        this.stock = stock;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void reduceStock(int quantity) {
        if (stock >= quantity) {
            stock -= quantity;
        } else {
            throw new RuntimeException("Insufficient stock");
        }
    }
    
}