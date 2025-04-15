import java.util.Scanner;

// Base class
class Publisher {
    String name;

    Publisher(String name) {
        this.name = name;
    }
}

// Book class inherits Publisher
class Book extends Publisher {
    String title;
    String author;

    Book(String name, String title, String author) {
        super(name);
        this.title = title;
        this.author = author;
    }

    void displayDetails() {
        System.out.println("Publisher: " + name);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Literature category
class Literature extends Book {
    Literature(String name, String title, String author) {
        super(name, title, author);
    }

    void display() {
        System.out.println("\n--- Literature Book Details ---");
        displayDetails();
    }
}

// Fiction category
class Fiction extends Book {
    Fiction(String name, String title, String author) {
        super(name, title, author);
    }

    void display() {
        System.out.println("\n--- Fiction Book Details ---");
        displayDetails();
    }
}

// Main class
public class BookCategory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Book " + (i + 1));
            System.out.print("Enter Publisher Name: ");
            String publisher = sc.nextLine();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Author Name: ");
            String author = sc.nextLine();

            System.out.print("Enter Category (Literature/Fiction): ");
            String category = sc.nextLine();

            if (category.equalsIgnoreCase("Literature")) {
                books[i] = new Literature(publisher, title, author);
            } else if (category.equalsIgnoreCase("Fiction")) {
                books[i] = new Fiction(publisher, title, author);
            } else {
                System.out.println("Invalid category! Skipping...");
            }
        }

        // Display all books by category
        System.out.println("\n===== LITERATURE BOOKS =====");
        for (Book book : books) {
            if (book instanceof Literature) {
                ((Literature) book).display();
            }
        }

        System.out.println("\n===== FICTION BOOKS =====");
        for (Book book : books) {
            if (book instanceof Fiction) {
                ((Fiction) book).display();
            }
        }

        sc.close();
    }
}

