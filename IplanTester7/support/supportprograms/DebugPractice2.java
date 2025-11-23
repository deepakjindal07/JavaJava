/*
 * @author Deepak Jindal
 *
 */
package supportprograms;

class Book {
    String title;
    String author;

    // Constructor to initialize title and author
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    public void display() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

public class DebugPractice2 {
    public static void main(String[] args) {
        // Creating an array to hold 3 Book objects
        Book[] library = new Book[3];

        int a =1;
        System.out.println(a);

        String something = "SomethingString";
        System.out.println(something);


        // Creating Book objects and assigning them to array slots
        library[0] = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        library[1] = new Book("To Kill a Mockingbird", "Harper Lee");
        library[2] = new Book("1984", "George Orwell");

        // Displaying details of books in the library
        System.out.println("Books in the library:");
        for (Book element : library) {
            element.display();
        }
    }
}
