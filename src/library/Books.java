public class Books{
    String title;
    String author;
    double price;
    int edition;
    int bookId;
    boolean isAvailable;

    public Books(String title, String author, double price, int edition, int bookId, boolean isAvailable){
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
    }
}