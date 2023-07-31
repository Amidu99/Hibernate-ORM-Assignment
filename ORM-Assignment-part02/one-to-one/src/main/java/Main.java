import entity.Book;
import entity.Author;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

public class Main {
    public static void main(String[] args) {
        System.out.println("Start");

        Author author = new Author();
        author.setId("A001");
        author.setName("Kumara");
        author.setAddress("Kalutara");

        Book book = new Book();
        book.setIsbn("I001");
        book.setTitle("Kaliyugaya");
        book.setPages(256);
        book.setPrice(499.99);
        book.setAuthor(author);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        session.persist(author);
        session.persist(book);

        transaction.commit();
        session.close();

        System.out.println("End");
    }
}