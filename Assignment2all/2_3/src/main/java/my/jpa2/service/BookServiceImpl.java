package my.jpa2.service;

import my.jpa2.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Service("jpaBookService")
@Repository
@Transactional
@SuppressWarnings("unchecked")
public class BookServiceImpl implements BookService {
    final static String ALL_BOOK_NATIVE_QUERY =
        "select id, category_id, title, isbn, price from book";

    private static Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @PersistenceContext
    private EntityManager em;

    @Transactional(readOnly=true)
    @Override
    public List<Book> findAll() {
        return em.createNamedQuery(Book.FIND_ALL, Book.class).getResultList();
    }
    
    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllWithCategoryAuthor() {
        List<Book> books = em.createNamedQuery(Book.FIND_ALL_WITH_CATEGORY_AUTHOR,
        		Book.class).getResultList();
        return books;
    }

    @Transactional(readOnly=true)
    @Override
    public Book findBookWithCategoryAuthorById(Long id) {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_ID,
        		Book.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }


    @Transactional(readOnly=true)
    @Override
    public Book findBookWithCategoryAuthorByAuthorId(Long id) {
        TypedQuery<Book> query = em.createNamedQuery(Book.FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID,
                Book.class);
                query.setParameter("id", id);
        return   query.getSingleResult();

    }

    @Override
    public Book save(Book book) {
        if (book.getId() == null) {
            logger.info("Inserting new book");
            em.persist(book);
        } else {
            em.merge(book);
            logger.info("Updating existing book");
        }

        logger.info("Book saved with id: " + book.getId());

        return book;
    }

    @Override
    public void delete(Book book) {
        Book mergedContact = em.merge(book);
        em.remove(mergedContact);

        logger.info("Book with id: " + book.getId()  + " deleted successfully");
    }

    @Transactional(readOnly=true)
    @Override
    public List<Book> findAllByNativeQuery() {
        return em.createNativeQuery(ALL_BOOK_NATIVE_QUERY, "bookResult").getResultList();
    }    
}
