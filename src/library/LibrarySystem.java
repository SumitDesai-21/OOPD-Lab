import java.util.Scanner;

public class LibrarySystem {
    static int BOOKS_ISSUED = 0;
    public static void main(String[] args) {
        Books[] books = {
                new Books("Clean Code", "Robert Martin", 450, 1, 362232, true),
                new Books("Effective Java", "Joshua Bloch", 550, 3, 483523, true),
                new Books("Head First Java", "Kathy Sierra", 400, 2, 273324, true),
                new Books("Java The Complete Reference", "Herbert Schildt", 650, 526, 138251, true),
                new Books("Think Java", "Allen Downey", 300, 2, 687936, true),
                new Books("Algorithms", "Robert Sedgewick", 700, 4, 457894, true),
                new Books("Data Structures in Java", "Narasimha Karumanchi", 500, 1, 384376, true),
                new Books("Operating System Concepts", "Silberschatz", 600, 10, 794074, true),
                new Books("Computer Networks", "Andrew Tanenbaum", 580, 5, 567894, true),
                new Books("Database System Concepts", "Korth", 620, 6, 34565, true),
                new Books("Let Us C", "Yashavant Kanetkar", 250, 15, 439847, true),
                new Books("C Programming Language", "Dennis Ritchie", 350, 2, 579834, true),
                new Books("Python Crash Course", "Eric Matthes", 480, 2, 697842, true),
                new Books("Design Patterns", "Erich Gamma", 720, 1, 987653, true),
                new Books("Refactoring", "Martin Fowler", 680, 2, 767834, true)
        };
        System.out.println("Welcome To COEP Library.");
        Scanner sc = new Scanner(System.in);
        
        boolean repeat = true;
        do{ 
            System.out.println("What do you want? ");
            int choice = menu(sc);
            switch (choice) {
                case 1:
                    System.out.println("Books:");
                    for (int i = 0; i < books.length; i++) {
                        if (books[i] == null) continue;
                        String status = books[i].isAvailable ? "Available" : "Not Available";
                        System.out.println((i + 1) + ". " + " BookId: "+ books[i].bookId  + " | " + books[i].title + " by " + books[i].author + " | Edition: " + books[i].edition + " | Price: Rs." + books[i].price + " | Status: " + status);
                    }
                    break;
                    
                case 2:
                    System.out.print("Enter id of book you want to issue. ");
                    int bookId = sc.nextInt();
                    boolean noBookWithId = true;
                  
                    for(int i = 0; i < books.length; i++){
                        if(books[i] == null) continue;
                        if(books[i].bookId == bookId){
                            noBookWithId  = false;
                            String status = books[i].isAvailable ? "is Available" : "is Not Available";
                            System.out.println(books[i].title + " by " + books[i].author+ " bookId: "+ bookId + " " + status);                            
                            
                            if(books[i].isAvailable){
                                System.out.print("Do you want to issue this book (yes or no)? ");
                                if(sc.next().toLowerCase().equals("yes")){
                                    BOOKS_ISSUED++;
                                    System.out.println("Book with bookId: "+ bookId+ " issued to you");
                                    books[i].isAvailable = false;
                                    break;
                                }
                                else{
                                    System.out.println("No problem! have a great day");
                                    break;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        break;
                    }
                    if(noBookWithId){
                        System.out.println("Sorry! There's no book with bookId: "+ bookId);
                        break;
                    }
                    break;

                case 3:
                    System.out.println("Enter id of the book you want to return: ");
                    bookId = sc.nextInt();
                    noBookWithId = false;

                    for(int i = 0; i < books.length; i++){
                        if(books[i] == null) continue;
                        if(books[i].bookId == bookId){
                            noBookWithId = true;
                    
                            if(books[i].isAvailable){
                                System.out.println(books[i].title + " by " + books[i].author+ " bookId: "+ bookId + " is already available" );  
                                break;                          
                            }
                            if(!books[i].isAvailable){
                                System.out.print("Do you want to return this book (yes or no)? ");
                                if(sc.next().toLowerCase().equals("yes")){
                                    BOOKS_ISSUED--;
                                    System.out.println("Book with bookId: "+ bookId+ " returned.");
                                    books[i].isAvailable = true;
                                    break;
                                }
                                else{
                                    System.out.println("No problem! have a great day");
                                    break;
                                }
                            }
                            else{
                                break;
                            }
                        }
                        if(noBookWithId){
                            System.out.println("Sorry! Book with bookId: "+ bookId+" wasn't issued.");
                            break;
                        }
                        break;
                    }
                default:
                    break;
            }
            System.out.print("\nDo you want to continue? (yes or no) ");
            repeat = sc.next().toLowerCase().equals("yes");

        }
        while(repeat);

        System.out.println("Analytics: ");
        System.out.println("Total number of books: "+ books.length);
        System.out.println("Books issued: "+ BOOKS_ISSUED);
        System.out.println("Program exited successfully.");
    }
    static int menu(Scanner sc){
        System.out.println("1. See all books.\n2. Issue a book with bookId.\n3. Return book issued to you.");
        return sc.nextInt();
    }
}
