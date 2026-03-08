package library;

public class Book {
    // Instance variables
    String title;
    String author;
    double price;
    int edition;
    int bookId;
    boolean isAvailable;

    // Class variables i.e static 
    static int totalBooks = 0;
    static int totalBooksIssued = 0;

    Book(String title, String author, double price, int edition, int bookId) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.edition = edition;
        this.bookId = bookId;
        this.isAvailable = true;
        totalBooks++;
    }

    // Issue this book
    boolean issue() {
        if (this.isAvailable) {
            this.isAvailable = false;
            totalBooksIssued++;
            return true;
        }
        return false;
    }

    // Return this book
    boolean returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            totalBooksIssued--;
            return true;
        }
        return false;
    }

    // Display book info
    void displayInfo() {
        String status = isAvailable ? "Available" : "Issued";
        System.out.println("BookId: " + bookId + " | " + title + " by " + author +
                " | Edition: " + edition + " | Price: Rs." + price + " | Status: " + status);
    }

    // Get issued percentage
    static double getIssuedPercentage() {
        if (totalBooks == 0) return 0;
        return ((double) totalBooksIssued / totalBooks) * 100;
    }

    // Display analytics
    static void displayAnalytics() {
        System.out.println("\nAnalytics: ");
        System.out.println("Total books: " + totalBooks);
        System.out.println("Books issued: " + totalBooksIssued);
        System.out.printf("Issued Percentage: %.2f%%%n", getIssuedPercentage());
    }
}
