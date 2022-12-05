import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryServiceImp implements LibraryService{

    private final File file;
    private final List<Book> books = new ArrayList<>();
    private final Scanner sc;
    public LibraryServiceImp(File file, Scanner sc){
        this.file = file;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Book book = new Book(values[0],values[1],values[2],Integer.parseInt(values[3]),Boolean.parseBoolean(values[4]));
                books.add(book);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.sc = sc;
    }

    public Book addBook() throws FileNotFoundException {
        System.out.println("Enter name of book:");
        String bookName = sc.nextLine();
        System.out.println("Enter author:");
        String bookAuthor = sc.nextLine();
        System.out.println("Enter short description:");
        String bookDescription = sc.nextLine();
        System.out.println("Enter the year");
        int bookYear = Integer.parseInt(sc.nextLine());

        Book newBook = new Book(bookName, bookAuthor, bookDescription, bookYear);
        books.add(newBook);

        return newBook;
    }

    public List<Book> getBooks(){
        return books;
    }

    public Book updateBook() throws FileNotFoundException {
        System.out.println("Enter the numeber of the book");
        int id = Integer.parseInt(sc.nextLine());
        if (id > 0 && id < books.size()){
            System.out.println("Enter name of book:");
            String bookName = sc.nextLine();
            System.out.println("Enter author:");
            String bookAuthor = sc.nextLine();
            System.out.println("Enter short description:");
            String bookDescription = sc.nextLine();

            System.out.println("Enter the year");
            Integer bookYear = null;
            try {
                bookYear = Integer.parseInt(sc.nextLine());
            } catch (Exception ignored){

            }

            if (!bookName.equals("")){
                books.get(id).setName(bookName);
            }
            if (!bookAuthor.equals("")){
                books.get(id).setAuthor(bookAuthor);
            }
            if (!bookDescription.equals("")){
                books.get(id).setDescription(bookDescription);
            }
            if (bookYear != null) {
                books.get(id).setYear(bookYear);
            }

            System.out.println("Book was changed successfully");
            return books.get(id);

        } else {
            System.out.println("Your id is not valid.");
            return null;
        }
    }

    public void deleteBook() throws FileNotFoundException {
        System.out.println("Enter the number of the book");
        int id = Integer.parseInt(sc.nextLine());
        books.remove(id);
        System.out.println("Book was deleted successfully");
    }

    public void makeBooking() throws FileNotFoundException {
        System.out.println("Enter the number of book you would like to book");
        int id = Integer.parseInt(sc.nextLine());
        books.get(id).setBooked(true);
        System.out.println("Book was booked successfully");
    }

    public void unbook() throws FileNotFoundException {
        System.out.println("Enter the number of book you would like to book");
        int id = Integer.parseInt(sc.nextLine());
        books.get(id).setBooked(false);
        System.out.println("Book was booked successfully");
    }

    @Override
    public void saveChanges() throws FileNotFoundException {

        PrintWriter writer = new PrintWriter(new FileOutputStream(file));
        for (Book b: books){
            writer.println(b);
        }
        writer.close();

    }

}
