public class Book {

    private String name;
    private String author;
    private String description;
    private int year;
    private boolean isBooked;

    public Book() {

    }

    public int getYear() {
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

    public String repr(){
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
