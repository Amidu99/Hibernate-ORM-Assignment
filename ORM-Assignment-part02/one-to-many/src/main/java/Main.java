import entity.Book;
import entity.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        Book book1 = new Book();
        book1.setIsbn("I001");
        book1.setTitle("Kaliyugaya");
        book1.setPages(323);
        book1.setPrice(399.99);

        Book book2 = new Book();
        book2.setIsbn("I002");
        book2.setTitle("Yuganthaya");
        book2.setPages(292);
        book2.setPrice(499.99);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        Author author = new Author();
        author.setId("A001");
        author.setName("Martin Wickramasinghe");
        author.setAddress("Koggala");
        author.setBooks(books);

        book1.setAuthor(author);
        book2.setAuthor(author);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(book1);
        session.persist(book2);
        session.persist(author);

        transaction.commit();
        session.close();

        System.out.println("End");
    }
}