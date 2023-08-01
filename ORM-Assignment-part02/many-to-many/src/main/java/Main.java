import entity.Author;
import entity.Book;
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

        Author author1 = new Author();
        author1.setId("A001");
        author1.setName("Martin Wickramasinghe");
        author1.setAddress("Koggala");

        Author author2 = new Author();
        author2.setId("A002");
        author2.setName("Kumarathunga Munidasa");
        author2.setAddress("Dikwella");

        List<Author> authors = new ArrayList<>();
        authors.add(author1);
        authors.add(author2);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        author1.setBooks(books);
        author2.setBooks(books);

        book1.setAuthors(authors);
        book2.setAuthors(authors);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author1);
        session.persist(author2);
        session.persist(book1);
        session.persist(book2);

        transaction.commit();
        session.close();

        System.out.println("End");
    }
}