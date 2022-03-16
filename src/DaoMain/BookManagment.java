package DaoMain;

import DaoBeans.Daobeans;
import DaoInterface.DaoBookInterface;
import DaoInterface.DaoImp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class BookManagment {

    public static void main(String[] args) {
        DaoBookInterface daoBookInterface = new DaoImp();
        Daobeans book=null;
        String cont;
        do {

            daoBookInterface.MainMenu();
//        1. View all Books
//        2. Add Book
//        3. Delet Book
//        4. Find Book
            Scanner sc = new Scanner(System.in);
            System.out.println("Choose option:");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:

                    ArrayList books=null;
                            books=daoBookInterface.viewAllBooks();
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println(books.get(i));
                    }
                    break;
                case 2:
                    System.out.println("Enter Book Name");
                    String bookName = sc.nextLine();
                    System.out.println("Enter Author Name");
                    String authorName = sc.nextLine();
                    System.out.println("Enter price");
                    int price = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter Isbn");
                    int isbn = Integer.parseInt(sc.nextLine());
                    book.setBook(bookName);
                    book.setAuthorName(authorName);
                    book.setPrice(price);
                    book.setIsbn(isbn);
                    daoBookInterface.addBook(book);
                    break;
                case 3:
                    System.out.println("Enter Isbn Number You Want to Delete");
                    int del = Integer.parseInt(sc.nextLine());
                    daoBookInterface.deleteBook(del);
                    break;
                case 4:
                    System.out.println("Enter Isbn Number You Want to Find");
                    int find = Integer.parseInt(sc.nextLine());
                    System.out.println(daoBookInterface.findBook(find));

                    break;
                case 5:
                    System.out.println("1.Update Book Name \n 2.Update Author Name \n 3. Update price \n Enter Choice");
                    int ch = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter isbn:");
                    int isb = Integer.parseInt(sc.nextLine());
                    if (daoBookInterface.checkIsbn(isb)) {
                        System.out.println("Enter Updated values");
                        String name = sc.nextLine();
                        daoBookInterface.updateBook(ch, isb, name);
                    } else {
                        System.out.println("Record Not Found");
                    }

            }
            System.out.println("do you want to continue (y or n):");
            cont=sc.nextLine();
        }while (cont.equals("y") || cont.equals("Y"));

    }
}
