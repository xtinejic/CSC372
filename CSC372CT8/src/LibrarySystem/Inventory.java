package LibrarySystem;

import java.util.ArrayList;

public class Inventory {
	private ArrayList<Book> books;
	private ArrayList<Book> borrowedBooks;
	
	public Inventory() {
		books = new ArrayList<>();
		borrowedBooks = new ArrayList<>();
	}
	
	public void addBook(Book book) {
		books.add(book);
		System.out.println("Book added: " + book.getTitle());
	}
	
	public boolean borrowBook(String bookID) {
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			if (book.getID().equals(bookID)) {
				books.remove(i);
				borrowedBooks.add(book);
				System.out.println("Book borrowed: " + book.getTitle());
				return true;
			}
		}
		System.out.println("Book not found: " + bookID);
		return false; 
	}
	
	public boolean returnBook(String bookID) {
		for (int i = 0; i < borrowedBooks.size(); i++) {
			Book book = borrowedBooks.get(i);
			if (book.getID().equals(bookID)) {
				borrowedBooks.remove(i);
				books.add(book);
				System.out.println("Book returned: " + book.getTitle());
				return true;
			}
		}
		System.out.println("Book was not borrowed: " + bookID);
		return false;
	}
	
	public void printAll() {
		if (books.isEmpty()) {
			System.out.println("No books in inventory");
			return;
		}
		
		System.out.println("All Books In Inventory");
		for (Book book : books) {
			book.printBookDetails();
		}
	}
	
	public void searchByTitle(String title) {
		System.out.println("Search results for: " + title);
		boolean found = false;
		
		for (Book book : books) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				book.printBookDetails();
				found = true;
			}
		}
	}
	public int getAvailableCount() {
		return books.size();
	}
	public int getBorrowedCount() {
		return borrowedBooks.size();
	}
public void printBorrowedBooks() {
	if (borrowedBooks.isEmpty()) {
		System.out.println("No books are borrowed");
		return;
		}
	
	System.out.println(" *Borrowed Books* ");
	for (Book book : borrowedBooks) {
		System.out.println("ID: " + book.getID() + " | Title: " + book.getTitle());
		}
	}	
}
