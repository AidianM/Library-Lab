import java.util.ArrayList;
import java.util.List;

public class Library{
    // Add the missing implementation to this class
	private String address;
	public List<Book> books = new ArrayList<Book>();

	
	public Library(String libraryAddress) {
		this.address = libraryAddress;
	}
	
	private void addBook(Book newBook) {
		books.add(newBook);
	}

	
	private static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	public void printAddress() {
		System.out.println(this.address);
	}
	
	public void borrowBook(String title) {
		int catalogue = books.size();
		for (int i = 0; i<catalogue; i++) {
			if (books.get(i).getTitle().equals(title))
				if (books.get(i).isBorrowed()) {
					System.out.println("We're sorry, this book has already been borrowed");
					return;
				} else {
					System.out.println("You have borrowed " +title);
					books.get(i).borrowed = true;
					return;
					
				}
		}
		System.out.println("We're sorry, but this book isn't in our catalogue.");
	}
	
	public void printAvailableBooks() {
		if (books.size()== 0) {
			System.out.println("There are no books in this catalogue.");
		} else {
			for (int i = 0; i<books.size(); i++) {
				if (books.get(i).isBorrowed()==false) {
					System.out.println(books.get(i).getTitle());
					return;
				} 
			}
		}
	}
		

	public void returnBook(String title) {
		int catalogue = books.size();
		
		for (int i = 0; i < catalogue; i++) {
			if (books.get(i).getTitle().equals(title))
				if (books.get(i).isBorrowed()) {
					System.out.println("You have returned " +title);
					books.get(i).returned();
				} else {
					System.out.println("You haven't borrowed this book.");
					return;
				}

		}
		
		
		
	}
	
    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 