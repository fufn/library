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
                Book book = new Book();
                book.setName(values[0]);
                book.setAuthor(values[1]);
                book.setDescription(values[2]);
                book.setYear(Integer.parseInt(values[3]));
                book.setBooked(Boolean.parseBoolean(values[4]));
                books.add(book);
            }
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
        System.out.println("Enter the year");
        int book_year = Integer.parseInt(sc.nextLine());
        Book newBook = new Book();
        newBook.setName(book_name);
        newBook.setAuthor(book_author);
        newBook.setDescription(book_description);
        newBook.setYear(book_year);
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
            System.out.println(b.repr());
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
            System.out.println("Enter the year");
            int book_year = -1;
            try {
                book_year = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {

            }
            Book newBook = new Book();
            newBook.setName(book_name);
            newBook.setAuthor(book_author);
            newBook.setDescription(book_description);
            newBook.setYear(book_year);
            if (!newBook.getName().equals("")){
                books.get(id).setName(newBook.getName());
            }
            if (!newBook.getAuthor().equals("")){
                books.get(id).setAuthor(newBook.getAuthor());
            }
            if (!newBook.getDescription().equals("")){
                books.get(id).setDescription(newBook.getDescription());
            }
            if (newBook.getYear() != -1) {
                books.get(id).setYear(newBook.getYear());
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

    public void makeBooking() throws FileNotFoundException {
        System.out.println("Enter the number of book you would like to book");
        int id = Integer.parseInt(sc.nextLine());
        books.get(id).setBooked(true);
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));
        for (Book b: books){
            writer.println(b);
        }
        System.out.println("Book was booked successfully");
        writer.close();
    }

    public void unbook() throws FileNotFoundException {
        System.out.println("Enter the number of book you would like to book");
        int id = Integer.parseInt(sc.nextLine());
        books.get(id).setBooked(false);
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));
        for (Book b: books){
            writer.println(b);
        }
        System.out.println("Book was booked successfully");
        writer.close();
    }

}
