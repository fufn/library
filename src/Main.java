import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to the libraries!");
        File dir = new File("libs");
        File[] libraries = dir.listFiles();
        System.out.println("Here is the list of available libraries:");
        System.out.println();
        for (File lib : libraries) {
            System.out.println(lib.getName());
        }
        System.out.println();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the library to work with: ");
            String libraryName = sc.nextLine();
            if (libraryName.equals("exit")){
                return;
            }
            File file = new File(dir, libraryName);
            if (!file.exists()) {
                System.out.println("No such library, try another");
            } else {
                System.out.println("Welcome to the " + libraryName + "!");
                LibraryService libraryService = new LibraryServiceImp(file, sc);
                while (true) {
                    System.out.println("Enter your request");
                    String request = sc.nextLine();
                    if (request.equals("back")) {
                        libraryService.saveChanges();
                        break;
                    }
                    switch (request) {
                        case ("exit"):
                            libraryService.saveChanges();
                            return;
                        case ("create"):
                            System.out.println("Enter the details about the book.");
                            Book addedBook = libraryService.addBook();
                            System.out.println(addedBook);
                            break;
                        case ("read"):
                            List<Book> books = libraryService.getBooks();
                            if (books.size() == 0) {
                                System.out.println("There is no books in this library");
                            } else {
                                for (Book b : books){
                                    System.out.println(b.toStringForUsers());
                                }
                            }
                            break;
                        case ("update"):
                            Book updatedBook = libraryService.updateBook();
                            System.out.println(updatedBook);
                            break;
                        case ("delete"):
                            libraryService.deleteBook();
                            break;
                        case ("book"):
                            libraryService.makeBooking();
                            break;
                        case ("unbook"):
                            libraryService.unbook();
                            break;
                    }
                }
            }
        }
    }
}