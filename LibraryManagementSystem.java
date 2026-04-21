import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String title;
    boolean issued;

    Book(String title) {
        this.title = title;
        this.issued = false;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Show Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = sc.nextLine();
                    books.add(new Book(title));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (books.size() == 0) {
                        System.out.println("No books available.");
                    } else {
                        System.out.println("\nBooks List:");
                        for (int i = 0; i < books.size(); i++) {
                            System.out.println((i + 1) + ". " + books.get(i).title +
                                    (books.get(i).issued ? " (Issued)" : " (Available)"));
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter book number to issue: ");
                    int issue = sc.nextInt();
                    if (issue > 0 && issue <= books.size()) {
                        if (!books.get(issue - 1).issued) {
                            books.get(issue - 1).issued = true;
                            System.out.println("Book issued successfully!");
                        } else {
                            System.out.println("Book already issued.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 4:
                    System.out.print("Enter book number to return: ");
                    int ret = sc.nextInt();
                    if (ret > 0 && ret <= books.size()) {
                        if (books.get(ret - 1).issued) {
                            books.get(ret - 1).issued = false;
                            System.out.println("Book returned successfully!");
                        } else {
                            System.out.println("Book was not issued.");
                        }
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        sc.close();
    }
}