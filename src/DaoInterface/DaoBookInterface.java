package DaoInterface;

import DaoBeans.Daobeans;

import java.util.ArrayList;


public interface DaoBookInterface {
    void MainMenu();
    void addBook(Daobeans book);
    ArrayList viewAllBooks();
    Daobeans findBook(int isbn);
    void deleteBook(int isbn);
    Boolean checkIsbn(int isbn);
    void updateBook(int choice,int isbn,String name);
}
