public abstract class Book {
	private String isbn;
    private String title;
    private String author;
    private int yearOfPublication;
    private double price;

    public Book(String isbn, String title, String author, int yearOfPublication, double price) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.price = price;
    }
    public String getIsbn() {
        return isbn;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public int getYearOfPublication() {
        return yearOfPublication;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
}
