import java.util.Arrays;
import java.util.Comparator;

class Book {
    int bookId;
    String title;
    String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String toString() {
        return "BookID: " + bookId + ", Title: " + title + ", Author: " + author;
    }
}

public class LibraryManagementSystem {

    // Linear Search
    public static Book linearSearch(Book[] books, String searchTitle) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(searchTitle)) {
                return b;
            }
        }
        return null;
    }

    // Binary Search (requires sorted array)
    public static Book binarySearch(Book[] books, String searchTitle) {
        int low = 0;
        int high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(searchTitle);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    // Print all books
    public static void printBooks(Book[] books) {
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "Java Programming", "Alice"),
            new Book(102, "Data Structures", "Bob"),
            new Book(103, "Algorithms", "Carol"),
            new Book(104, "Operating Systems", "David"),
            new Book(105, "Database Systems", "Eve")
        };

        System.out.println("=== All Books ===");
        printBooks(books);

        System.out.println("\n=== Linear Search for 'Algorithms' ===");
        Book foundLinear = linearSearch(books, "Algorithms");
        System.out.println(foundLinear != null ? foundLinear : "Book not found.");

        // Sort books by title for binary search
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));

        System.out.println("\n=== Binary Search for 'Algorithms' ===");
        Book foundBinary = binarySearch(books, "Algorithms");
        System.out.println(foundBinary != null ? foundBinary : "Book not found.");
    }
}
