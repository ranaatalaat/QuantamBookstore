public class Ebook extends Book {
    String filetype;
    public Ebook (String isbn, String title ,String author, int yearOfPublication, double price, String filetype) {
        super(isbn, title,author, yearOfPublication ,price);
        this.filetype = filetype;
    }
    public String getFiletype() {
        return filetype;
    }
    
}
