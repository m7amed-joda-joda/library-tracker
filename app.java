
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class app {
    
    
     static void printBanner() {
        System.out.println("=== Library Tracker ===");
    }
     
         static ArrayList<String> loadBooks() {
        ArrayList<String> books = new ArrayList<String>();
        try {
            File file = new File("books.json");
            if (!file.exists()) {
                return books;
            }
            Scanner sc = new Scanner(file);
            while (sc.hasNextLine()) {
                books.add(sc.nextLine());
            }
            sc.close();
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return books;
    }
         
         
     public static void main(String[] args) {
      printBanner();
      Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. List Books");
            System.out.println("2. Add Book");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook(scanner);
                    break;
                case 2:
                      listBooks();
                    
                    break;
                case 3:
                    searchBooks(scanner);
                    break;
                case 4:
                    removeBook(scanner);
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting... Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
            
     
     
     }
     
     
     
     static void saveBooks(ArrayList<String> books) {
        try {
            PrintWriter pw = new PrintWriter("books.json");
            for (int i = 0; i < books.size(); i++) {
                pw.println(books.get(i));
            }
            pw.close();
        } catch (IOException e) {
            System.out.println("Error saving file");
        }
    }

    static void addBook(Scanner input) {
        System.out.print("Title: ");
        String title = input.nextLine();
        System.out.print("Author: ");
        String author = input.nextLine();

        ArrayList<String> books = loadBooks();
        books.add(title + ";" + author);
        saveBooks(books);
        System.out.println("Added: " + title);
    }
     
    
        static void listBooks() {
        ArrayList<String> books = loadBooks();
        if (books.isEmpty()) {
            System.out.println("No books yet");
        }
        for (int i = 0; i < books.size(); i++) {
            String[] parts = books.get(i).split(";");
            System.out.println((i + 1) + ". " + parts[0] + " - " + parts[1]);
        }
    }
    static void searchBooks(Scanner input) {
        System.out.print("Keyword: ");
        String keyword = input.nextLine().toLowerCase();

        ArrayList<String> books = loadBooks();
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).toLowerCase().contains(keyword)) {
                String[] parts = books.get(i).split(";");
                System.out.println(parts[0] + " - " + parts[1]);
            }
        }
    }
     static void removeBook(Scanner input) {
        System.out.print("Title to remove: ");
        String title = input.nextLine();

        ArrayList<String> books = loadBooks();
        boolean found = false;
        for (int i = 0; i < books.size(); i++) {
            String[] parts = books.get(i).split(";");
            if (parts[0].equalsIgnoreCase(title)) {
                books.remove(i);
                found = true;
                break;
            }
        }
        if (found) {
            saveBooks(books);
            System.out.println("Removed: " + title);
        } else {
            System.out.println("Not found");
        }
    }
     
}