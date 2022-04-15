public class Book {

    String title;
    boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
    	this.title = bookTitle;
    }
    
    // Marks the book as rented
    
    public void borrowed() {
    	this.borrowed = true;
    }

    // Marks the book as not rented
    public void returned() {
        this.borrowed=false;
    }
    

    
    public boolean isBorrowed() {
    	return this.borrowed;
    }
   
   
    // Returns the title of the book
    public String getTitle() {
    	return this.title;
    }
    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.borrowed(); //this was in as rented? Changed to fit parameters.
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
} 