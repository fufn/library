import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    private File file;
    private List<Book> books = new ArrayList<>();
    private Scanner sc;
    public Library(File file, Scanner sc){
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
        String book_name = sc.nextLine();
        String book_author = sc.nextLine();
        String book_description = sc.nextLine();
        Book newBook = new Book();
        newBook.setName(book_name);
        newBook.setAuthor(book_author);
        newBook.setDescription(book_description);
        books.add(newBook);
        PrintWriter writer = new PrintWriter(new FileOutputStream(file, true));
        writer.println(newBook);
        writer.close();
    }

    public void getBooks(){
        for (Book b : books){
            System.out.println(b);
        }
    }

}
