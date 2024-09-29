/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.project;


import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Hadahya salem
 */
class Library {
     private int capacity;
    private ArrayList<Book> books;

    public Library(int capacity) {
        this.capacity = capacity;
        this.books = new ArrayList<Book>();
    }

    public void addBook() {
        if (books.size() < capacity) {
            int id = books.size() + 1;
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter book name: ");
            String name = scanner.nextLine();
            System.out.print("Enter book category (Biology, Maths, History, Chemistry, Politics): ");
            String category = scanner.nextLine();
            Book book = new Book(id, name, category);
            books.add(book);
            System.out.println("Book added successfully");
        } else {
            System.out.println("Library is full, cannot add more books");
        }
    }

    public void removeBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) {
                    System.out.println("Cannot remove a borrowed book");
                    return;
                }
                books.remove(book);
                System.out.println("Book removed successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void borrowBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == id) {
                if (book.isBorrowed()) {
                    System.out.println("Book is already borrowed");
                    return;
                }
                System.out.print("Enter borrowing period (in days): ");
                int borrowingPeriod = scanner.nextInt();
                book.setBorrowed(true);
                book.setBorrowingPeriod(borrowingPeriod);
                book.setBorrowingDate(new Date());
                System.out.println("Book borrowed successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void returnBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book ID: ");
        int id = scanner.nextInt();
        for (Book book : books) {
            if (book.getId() == id) {
                if (!book.isBorrowed()) {
                    System.out.println("Book is not borrowed");
                    return;
                }
                Date borrowingDate = book.getBorrowingDate();
                int borrowingPeriod = book.getBorrowingPeriod();
                Date today = new Date();
                long daysLate = (today.getTime() - borrowingDate.getTime()) / (1000 * 60 * 60 * 24) - borrowingPeriod;
                if (daysLate > 0) {
                    double fine = daysLate * 0.5;
                    System.out.printf("Book returned late, fine is $%.2f\n", fine);
                }
                book.setBorrowed(false);
                book.setBorrowingPeriod(0);
                book.setBorrowingDate(null);
                System.out.println("Book returned successfully");
                return;
            }
        }
        System.out.println("Book not found");
    }

    public void viewLibraryStatus() {
        String[] categories = {"Biology", "Maths", "History", "Chemistry", "Politics"};
        int[] categoryCounts = new int[categories.length];
        int borrowedCount = 0;
        for (Book book : books) {
            String status;
            if (book.isBorrowed()) {
                status = String.format("Borrowed on %tF for %d days", book.getBorrowingDate(), book.getBorrowingPeriod());
                borrowedCount++;
            } else {
                status = "Available";
            }
            System.out.printf("%d - %s (%s) - %s\n", book.getId(), book.getName(), book.getCategory(), status);
            for (int i = 0; i < categories.length; i++) {
                if (book.getCategory().equals(categories[i])) {
                    categoryCounts[i]++;
                    break;
                }
            }
        }
        for (int i = 0; i < categories.length; i++) {
            System.out.printf("%s: %d\n", categories[i], categoryCounts[i]);
        }
        System.out.printf("Total books: %d\n", books.size());
        System.out.printf("Total borrowed books: %d\n", borrowedCount);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome to the library system!");
            System.out.println("Please select an option:");
            System.out.println("1- Add a book");
            System.out.println("2- Remove a book");
            System.out.println("3- Borrow a book");
            System.out.println("4- Return a book");
            System.out.println("5- View library status");
            System.out.println("6- Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    viewLibraryStatus();
                    break;
                case 6:
                    System.out.println("Exiting the system...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again");
            }
        }
    }


}


