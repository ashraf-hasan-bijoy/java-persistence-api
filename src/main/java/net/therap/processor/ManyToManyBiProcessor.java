package net.therap.processor;

import net.therap.domain.manyTomanyBi.Author;
import net.therap.domain.manyTomanyBi.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import java.util.Arrays;

/**
 * @author ashrafhasan
 * @since 10/29/16
 */
public class ManyToManyBiProcessor implements DbCommandProcessor {

    Logger logger = LoggerFactory.getLogger(ManyToManyBiProcessor.class);

    @Override
    public void process(EntityManager entityManager) {
        Author johnDoe = new Author("John Doe");
        Author maryActive = new Author("Mary Active");
        Author jamesMorgan = new Author("James Morgan");

        entityManager.persist(johnDoe);
        entityManager.persist(maryActive);
        entityManager.persist(jamesMorgan);

        Book book1 = new Book("Book 1");
        Book book2 = new Book("Book 2");
        Book book3 = new Book("Book 3");

        book1.setAuthorList(Arrays.asList(johnDoe, maryActive));
        book2.setAuthorList(Arrays.asList(maryActive, jamesMorgan));
        book3.setAuthorList(Arrays.asList(jamesMorgan, johnDoe));

        entityManager.persist(book1);
        entityManager.persist(book2);
        entityManager.persist(book3);
        logger.debug("======================== Sql for saving start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for saving end ========================");
        entityManager.clear();

        book1 = entityManager.find(Book.class, book1.getId());
        book2 = entityManager.find(Book.class, book2.getId());
        book3 = entityManager.find(Book.class, book3.getId());

        book1.getAuthorList().add(jamesMorgan);
        book2.getAuthorList().add(johnDoe);
        book3.getAuthorList().add(maryActive);

        logger.debug("======================== Sql for updating start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for updating end ========================");
        entityManager.clear();

        book1 = entityManager.find(Book.class, book1.getId());
        book2 = entityManager.find(Book.class, book2.getId());
        book3 = entityManager.find(Book.class, book3.getId());

        book1.getAuthorList().remove(0);
        book2.getAuthorList().remove(0);
        book3.getAuthorList().remove(0);

        logger.debug("======================== Sql for removing start ========================");
        entityManager.flush();
        logger.debug("======================== Sql for removing end ========================");
        entityManager.clear();

        johnDoe = entityManager.find(Author.class, johnDoe.getId());
        maryActive = entityManager.find(Author.class, maryActive.getId());
        jamesMorgan = entityManager.find(Author.class, jamesMorgan.getId());

        logger.debug("John Doe: {}", johnDoe);
        logger.debug("Mary Active: {}", maryActive);
        logger.debug("James Morgan: {}", jamesMorgan);

        //uncomment @OrderColumn and run again
    }
}
