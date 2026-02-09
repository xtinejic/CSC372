package LibrarySystem;

public class Main {
	    public static void main(String[] args) {
	        Inventory library = new Inventory();
	        
	        Book book1 = new Book("B001", "The Poppy War", "R.F. Kuang", "978-0062662583", 544);
	        Book book2 = new Book("B002", "The Dragon Republic", "R.F. Kuang", "‎978-0062662637", 672);
	              
	        library.addBook(book1);
	        library.addBook(book2);
	        
	        System.out.println("All books in library:");
	        library.printAll();
	        
	        System.out.println("Available books: " + library.getAvailableCount());
	        System.out.println("Borrowed books: " + library.getBorrowedCount());
	        
	        System.out.println("\nBorrowing book B001...");
	        boolean success = library.borrowBook("B001");
	        if (success) {
	            System.out.println("Book borrowed successfully!");
	        } else {
	            System.out.println("Book not found!");
	        }
	        
	        System.out.println("\nAfter borrowing:");
	        System.out.println("Available books: " + library.getAvailableCount());
	        System.out.println("Borrowed books: " + library.getBorrowedCount());
	        
	        System.out.println("\nBorrowed books list:");
	        library.printBorrowedBooks();
	        
	        System.out.println("\nRemaining available books:");
	        library.printAll();
	    }
	}
