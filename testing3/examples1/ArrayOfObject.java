package examples1;

// Define a class representing a Book
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

public class ArrayOfObject {
    public static void main(String[] args) {
        // Creating an array to hold 3 Book objects
        Book[] library = new Book[3];

        // Creating Book objects and assigning them to array slots

        library[1] = new Book("To Kill a Mockingbird", "Harper Lee");
        library[2] = new Book("1984", "George Orwell");

        // Displaying details of books in the library
        System.out.println("Books in the library:");
        for (Book element : library) {
            element.display();
        }
    }
}
