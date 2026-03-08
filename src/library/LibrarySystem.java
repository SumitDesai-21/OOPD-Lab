package library;

import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Book[] books = {
                new Book("Clean Code", "Robert Martin", 450, 1, 362232),
                new Book("Effective Java", "Joshua Bloch", 550, 3, 483523),
                new Book("Head First Java", "Kathy Sierra", 400, 2, 273324),
                new Book("Java The Complete Reference", "Herbert Schildt", 650, 526, 138251),
                new Book("Think Java", "Allen Downey", 300, 2, 687936),
                new Book("Algorithms", "Robert Sedgewick", 700, 4, 457894),
                new Book("Data Structures in Java", "Narasimha Karumanchi", 500, 1, 384376),
                new Book("Operating System Concepts", "Silberschatz", 600, 10, 794074),
                new Book("Computer Networks", "Andrew Tanenbaum", 580, 5, 567894),
                new Book("Database System Concepts", "Korth", 620, 6, 345657),
                new Book("Let Us C", "Yashavant Kanetkar", 250, 15, 439847),
                new Book("C Programming Language", "Dennis Ritchie", 350, 2, 579834),
                new Book("Python Crash Course", "Eric Matthes", 480, 2, 697842),
                new Book("Design Patterns", "Erich Gamma", 720, 1, 987653),
                new Book("Refactoring", "Martin Fowler", 680, 2, 767834)
        };

        System.out.println("Welcome To COEP Library.");
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat do you want?");
            int choice = menu(sc);

            switch (choice) {
                case 1:
                    System.out.println("\nAll Books: ");
                    for (int i = 0; i < books.length; i++) {
                        System.out.print((i + 1) + ". ");
                        books[i].displayInfo();
                    }
                    break;

                case 2: {
                    System.out.print("Enter bookId to issue: ");
                    int bookId = sc.nextInt();
                    Book book = findBookById(books, bookId);

                    if (book == null) {
                        System.out.println("No book with bookId: " + bookId);
                        break;
                    }

                    book.displayInfo();

                    if (!book.isAvailable) {
                        System.out.println("Sorry! This book is already issued.");
                        break;
                    }

                    System.out.print("Issue this book? (yes/no): ");
                    if (sc.next().equalsIgnoreCase("yes")) {
                        book.issue();
                        System.out.println("Book issued successfully!");
                    }
                    break;
                }

                case 3: {
                    System.out.print("Enter bookId to return: ");
                    int bookId = sc.nextInt();
                    Book book = findBookById(books, bookId);

                    if (book == null) {
                        System.out.println("No book with bookId: " + bookId);
                        break;
                    }

                    book.displayInfo();

                    if (book.isAvailable) {
                        System.out.println("This book wasn't issued.");
                        break;
                    }

                    System.out.print("Return this book? (yes/no): ");
                    if (sc.next().equalsIgnoreCase("yes")) {
                        book.returnBook();
                        System.out.println("Book returned successfully!");
                    }
                    break;
                }

                case 4:
                    Book.displayAnalytics();
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

            System.out.print("\nContinue? (yes/no): ");
            if (sc.next().equalsIgnoreCase("no")) break;
        }

        Book.displayAnalytics();
        sc.close();
        System.out.println("Program exited successfully.");
    }

    static int menu(Scanner sc) {
        System.out.println("1. See all books");
        System.out.println("2. Issue a book");
        System.out.println("3. Return a book");
        System.out.println("4. View analytics");
        System.out.print("Choice: ");
        return sc.nextInt();
    }

    static Book findBookById(Book[] books, int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) return book;
        }
        return null;
    }
}
