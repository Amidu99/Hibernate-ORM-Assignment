package lk.ijse.ORM;

import lk.ijse.ORM.entity.Book;
import lk.ijse.ORM.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start the programme...");

        saveBook(new Book("I001", "Gamperaliya", 234, 449.99));
        getBook("I001");
        updateBook(new Book("I001", "Gamperaliya updated", 235, 549.99));
        deleteBook("I001");

        System.out.println("End the programme.");
    }

    private static void deleteBook(String isbn) {
        System.out.println("Start deleting book...\n");

        Session session = FactoryConfiguration.getInstance().getSession();
        Book book = session.load(Book.class, isbn);

        // Check if the book exists in the database
        if (book == null) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            session.close();
            return;
        }

        // Delete the book from the database
        Transaction transaction = session.beginTransaction();
        session.delete(book);
        transaction.commit();
        System.out.println("Book with ISBN " + isbn + " deleted successfully.\n");

        session.close();
    }

    private static void updateBook(Book newBook) {
        System.out.println("Start updating book...\n");

        Session session = FactoryConfiguration.getInstance().getSession();
        Book book = session.load(Book.class, newBook.getIsbn());

        // Check if the book exists in the database
        if (book == null) {
            System.out.println("Book with ISBN " + newBook.getIsbn() + " not found..");
            session.close();
            return;
        }

        // Update the book information
        book.setTitle(newBook.getTitle());
        book.setPages(newBook.getPages());
        book.setPrice(newBook.getPrice());

        // Save the changes back to the database
        Transaction transaction = session.beginTransaction();
        session.update(book);
        transaction.commit();

        System.out.println("Updated Book Title : " + book.getTitle());
        System.out.println("Updated Book Pages : " + book.getPages() + " pages");
        System.out.println("Updated Book Price : Rs." + book.getPrice());
        System.out.println("Book with ISBN " + newBook.getIsbn() + " updated successfully.\n");

        session.close();
    }

    private static void getBook(String isbn) {
        System.out.println("Start retrieving book...\n");

        Session session = FactoryConfiguration.getInstance().getSession();
        Book book =  session.load(Book.class, isbn);

        if(book != null) {
            System.out.println("Book ISBN  : " + book.getIsbn());
            System.out.println("Book Title : " + book.getTitle());
            System.out.println("Book Pages : " + book.getPages() + " pages");
            System.out.println("Book Price : Rs." + book.getPrice());
            System.out.println("Book with ISBN " + book.getIsbn() + " retrieved successfully.\n");
        } else {
            System.out.println("Book with ISBN " + isbn + " not found..");
        }
        session.close();
    }

    private static void saveBook(Book book) {
        System.out.println("Start saving book...\n");

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.persist(book);
        transaction.commit();
        session.close();
        System.out.println("Book with ISBN " + book.getIsbn() + " saved successfully.\n");
    }
}