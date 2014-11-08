/**
 * 
 */

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * @author rovi
 * 
 */
public class CreateIT {

	@Test
	public void test() {
		Author author = new Author();
		author.setFirstname("J.R.R");
		author.setLastname("Tolkien");

		Book book = new Book();
		book.setTitle("Der Herr der Ringe - Die Gefährten");
		book.setReleaseDate(new Date());

		Book book2 = new Book();
		book2.setTitle("Der Herr der Ringe - Die zwei Türme");
		book2.setReleaseDate(new Date());

		ArrayList<Book> books = new ArrayList<Book>();
		books.add(book);
		books.add(book2);
		author.setBooks(books);
		book.setAuthor(author);
		book2.setAuthor(author);

		EntityManager em = Persistence.createEntityManagerFactory(
				"ch.bfh.swos.bookapp.domain").createEntityManager();

		em.getTransaction().begin();
		em.persist(author);
		em.getTransaction().commit();
	}
}
