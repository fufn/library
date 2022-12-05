import java.io.FileNotFoundException;
import java.util.List;

public interface LibraryService {
    public void addBook() throws FileNotFoundException;
    public void getBooks();
    public void updateBook() throws FileNotFoundException;
    public void deleteBook() throws FileNotFoundException;
    public void makeBooking() throws FileNotFoundException;
    public void unbook() throws FileNotFoundException;
}
