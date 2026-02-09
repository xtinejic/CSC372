package LibrarySystem;

public class Book {
	private String ID;
	private String title; 
	private String author; 
	private String ISBN;
	private int numberOfPages;

	public Book() { 
		this.ID = "";
		this.title = "";
		this.author = "";
		this.ISBN = "";
		this.numberOfPages = 0;
	}
	
	public Book(String ID, String title, String author, String ISBN, int numberOfPages) {
		this.ID = ID;
		this.title = title; 
		this.author = author;
		this.ISBN = ISBN;
		this.numberOfPages = numberOfPages;
	}
	
	public String getID() { 
		return ID;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getTitle() {
		return title; 
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAuthor() {
		return author; 
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getISBN() {
		return ISBN;
	}
	
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	
	public int getNumberOfPages() {
		return numberOfPages;
	}
	
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public void printBookDetails() {
		System.out.println("Book Details:");
		System.out.println("ID: " + ID);
		System.out.println("Title: " + title);
		System.out.println("Author: " + author);
		System.out.println("ISBN: " + ISBN);
		System.out.println("Number of pages: " + numberOfPages);
		System.out.println("***************************");
	}
}