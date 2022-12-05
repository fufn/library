import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
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
        Command command = new Command();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the library to work with: ");
            String library = sc.nextLine();
            File file = new File(dir, library);
            if (!file.exists()) {
                System.out.println("No such library, try another");
            } else {
                System.out.println("Welcome to the " + library + "!");
                Library library1 = new Library(file, sc);
                while (true) {
                    System.out.println("Enter your request");
                    String request = sc.nextLine();
                    if (request.equals("back")) {
                        break;
                    }
                    switch (request) {
                        case ("exit"):
                            return;
                        case ("create"):
                            System.out.println("Enter the details about the book.");
                            library1.addBook();
                            break;
                        case ("read"):
                            library1.getBooks();
                            break;
                        case ("update"):
                            library1.updateBook();
                            break;
                        case ("delete"):
                            library1.deleteBook();
                            break;
                        case ("book"):
                            library1.makeBooking();
                            break;
                        case ("unbook"):
                            library1.unbook();
                            break;
                    }
                }
            }
        }
    }
}