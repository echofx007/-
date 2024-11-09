public class Library {
    // Add the missing implementation to this class
    static String openinghours = "9 AM to 5 PM";
    String address;
    Book[] collections = {};

    public Library(String theaddress){
	address = theaddress;
    }
    public void addBook(Book theBook){
	Book[] box = new Book[collections.length + 1];
	box[box.length - 1] = theBook;
	for (int i = 0; i<collections.length; i++){
	    box[i] = collections[i];
	}
	collections = box;
    }
    public static void printOpeningHours() {
	System.out.println("Libraries are open daily from " + openinghours);
    }
    public void printAddress() {
	System.out.println(address);
    }
    public void borrowBook(String bookname) {
	if (collections.length == 0) {
	    System.out.println("Sorry, this book is not in our catalog");
	}
	for (int i = 0; i < collections.length; i++) {
	    if ((collections[i].title).equals(bookname)) {
		if (collections[i].borrowed == true) {
		    System.out.println("Sorry, this book is already borrowed.");
		    break;
		}
		System.out.println("You successfully borrowed " + bookname);
		collections[i].borrowed = true;
		break;
	    }
	    if (i == collections.length - 1) {
		System.out.println("Sorry, this book is not in our catalog");
	}
	    
	}
    }

    public void printAvailableBooks() {
	if (collections.length == 0) {
	    System.out.println("NO book in catalog");
		}
	for (int i = 0; i < collections.length; i++) {
	    if (collections[i].borrowed == false) {
		System.out.println(collections[i].title);
	    }
	}
    }

    public void returnBook(String bookname) {
	for (int i = 0; i < collections.length; i++) {
	    if ((collections[i].title).equals(bookname)) {
		collections[i].borrowed = false;
		System.out.println("You successfullly returned The Lord of the Rings");
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
