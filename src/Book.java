public class Book {

    private String name;
    private String author;
    private String description;
    private Integer year;
    private boolean isBooked;

    public Book(String name, String author, String description, Integer year, boolean isBooked) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.year = year;
        this.isBooked = isBooked;
    }
    public Book(String name, String author, String description, int year) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.year = year;
        this.isBooked = false;
    }

    public Book() {

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public String toStringForUsers(){
        if (isBooked()) {
            return getName() + "," + getAuthor() + "," + getDescription() + "," + getYear() + ",booked";
        } else {
            return getName() + "," + getAuthor() + "," + getDescription()+ "," + getYear() + ",not booked";
        }
    }

    @Override
    public String toString() {
        return getName() + "," + getAuthor() + "," + getDescription() + "," + getYear() + ","  + isBooked();
    }
}
