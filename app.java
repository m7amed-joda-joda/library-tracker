
import java.io.File;
import java.io.IOException;
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
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
}