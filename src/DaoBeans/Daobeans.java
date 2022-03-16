package DaoBeans;

public class Daobeans {
    private String book,authorName;
    private double isbn,price;

    public Daobeans(){

    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getIsbn() {
        return isbn;
    }

    public void setIsbn(double isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "Book{" + "book=" + book + ", authorName=" + authorName + ", isbn=" + isbn + ", price=" + price + '}';
    }

}
