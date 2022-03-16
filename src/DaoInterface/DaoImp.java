package DaoInterface;

import DaoBeans.Daobeans;
import DaoConnection.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DaoImp implements DaoBookInterface {
    static Connection con
            = DbConnection.getConnection();
    PreparedStatement pre = null;
    ArrayList<Daobeans> books = new ArrayList<>();

    @Override
    public void MainMenu() {
        System.out.println("Welcome to Library Managment");
        System.out.println("1. View all Books");
        System.out.println("2. Add Book");
        System.out.println("3. Delet Book");
        System.out.println("4. Find Book");
        System.out.println("5. Update Record");
    }

    @Override
    public void addBook(Daobeans book) {
        String sql = "INSERT INTO books (bookName, authorName, price, isbn) VALUES (?, ?, ?, ?)";
        try {
            pre = con.prepareStatement(sql);
            pre.setString(1, book.getBook());
            pre.setString(2, book.getAuthorName());
            pre.setDouble(3, book.getPrice());
            pre.setDouble(4, book.getIsbn());
            int i=pre.executeUpdate();
            if(i>0){
                System.out.println("Record Added Successfully");
            }else{
                System.err.println("Not added");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Daobeans> viewAllBooks() {
        Daobeans book ;
        books.clear();
        String sql = "select * from books";
        try {
            pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                book = new Daobeans();
                book.setBook(rs.getString("bookName"));
                book.setAuthorName(rs.getString("authorName"));
                book.setPrice(rs.getInt("price"));
                book.setIsbn(rs.getInt("isbn"));
                books.add(book);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        for (int i = 0; i < books.size(); i++) {
//            System.out.println(books.get(i));
//        }

        return books;
    }

    @Override
    public Daobeans findBook(int isbn) {

        ArrayList<Daobeans> ar=viewAllBooks();
        for (int i = 0; i < ar.size(); i++) {
            if(ar.get(i).getIsbn() == isbn) {
                //System.out.println(ar.get(i));
            return ar.get(i);
            }
        }


        return null;
    }

    @Override
    public void deleteBook(int isbn) {
        //viewAllBooks();
        ArrayList<Daobeans> ar = viewAllBooks();
        for (int i = 0; i < ar.size(); i++) {
            if(ar.get(i).getIsbn() == isbn) {
                String sql = "DELETE FROM `books` WHERE `books`.`isbn` = ?";
                try {

                    pre = con.prepareStatement(sql);
                    pre.setInt(1, isbn);
//                    System.out.println(pre);
                    if (pre.executeUpdate() > 0) {
                        System.out.println("Record Deleted Sucessfully");
                    } else {
                        System.out.println("Enter Correct isbn");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    @Override
    public Boolean checkIsbn(int isbn) {

        ArrayList<Daobeans> ar=viewAllBooks();
        for (int i = 0; i < ar.size(); i++) {
            if(ar.get(i).getIsbn() == isbn) {
                return true;
            }}

return false;
    }

    @Override
    public void updateBook(int choice, int isbn, String name) {
        Daobeans ar=findBook(isbn);
        if (ar != null) {
            System.out.println(ar.getBook());
        }else{
            System.out.println("records not found");
        }
        String sql="UPDATE `books` SET `price` = ? , `authorName` = ? , `bookName` = ? WHERE `books`.`isbn` = ?";
        String value=name;

        switch (choice){
            case 1:
                ar.setBook(value);
               
                break;
            case 2:

                ar.setAuthorName(value);
                break;
            case 3:
                ar.setPrice(Integer.parseInt(value));
                break;
            default:
                System.out.println("Please Select Correct option:");}
        try {
            pre=con.prepareStatement(sql);
            pre.setDouble(1,ar.getPrice());
            pre.setString(2,ar.getAuthorName());
            pre.setString(3, ar.getBook());
            pre.setInt(4,isbn);
            if(pre.executeUpdate()>0){
                System.out.println("Record Update Successfully");
            }else
            {
                System.out.println("Not Updated");
            }
           } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}


