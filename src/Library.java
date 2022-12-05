import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private File file;
    private List<Book> books = new ArrayList<>();
    private Scanner sc;
    public Library(File file, Scanner sc){
        this.file = file;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Book book = new Book();
                book.setName(values[0]);
                book.setAuthor(values[1]);
                book.setDescription(values[2]);
                book.setBooked(Boolean.parseBoolean(values[3]));
                books.add(book);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.sc = sc;
    }

    public void addBook() throws FileNotFoundException {
        System.out.println("Enter name of book:");
        String book_name = sc.nextLine();
        System.out.println("Enter author:");
        String book_author = sc.nextLine();
        System.out.println("Enter short description:");
        String book_description = sc.nextLine();
        Book newBook = new Book();
        newBook.setName(book_name);
        newBook.setAuthor(book_author);
        newBook.setDescription(book_description);
        books.add(newBook);
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));
        for (Book b: books){
            writer.println(b);
        }
        System.out.println("Book was added successfully");
        writer.close();
    }

    public void getBooks(){
        if (books.size() == 0) {
            System.out.println("There is no books in this library");
        }
        for (Book b : books){
            System.out.println(b);
        }
    }

    public void updateBook() throws FileNotFoundException {
        System.out.println("Enter the numeber of the book");
        int id = Integer.parseInt(sc.nextLine());
        if (id > 0 && id < books.size()){
            System.out.println("Enter name of book:");
            String book_name = sc.nextLine();
            System.out.println("Enter author:");
            String book_author = sc.nextLine();
            System.out.println("Enter short description:");
            String book_description = sc.nextLine();
            Book newBook = new Book();
            newBook.setName(book_name);
            newBook.setAuthor(book_author);
            newBook.setDescription(book_description);
            if (!newBook.getName().equals("")){
                books.get(id).setName(newBook.getName());
            }
            if (!newBook.getAuthor().equals("")){
                books.get(id).setAuthor(newBook.getAuthor());
            }
            if (!newBook.getDescription().equals("")){
                books.get(id).setDescription(newBook.getDescription());
            }
            PrintWriter writer = new PrintWriter(new FileOutputStream(file));
            for (Book b: books){
                writer.println(b);
            }
            System.out.println("Book was changed successfully");
            writer.close();
        } else {
            System.out.println("Your id is not valid.");
        }
    }

    public void deleteBook() throws FileNotFoundException {
        System.out.println("Enter the number of the book");
        int id = Integer.parseInt(sc.nextLine());
        books.remove(id);
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));
        for (Book b: books){
            writer.println(b);
        }
        System.out.println("Book was deleted successfully");
        writer.close();
    }

}
