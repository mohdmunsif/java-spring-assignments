package my.hibernate.dao;

import my.hibernate.domain.Book;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@SuppressWarnings("unchecked")
@Transactional
@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	private static final Log logger = LogFactory.getLog(BookDaoImpl.class);
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<Book> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from Book b").list();
	}

	@Transactional(readOnly = true)
	public Book findById(Long id) {
		return (Book) sessionFactory.getCurrentSession().
				getNamedQuery("Book.findById").
				setParameter("id", id).uniqueResult();
	}

	@Transactional(readOnly = true)
	public List<Book> findAllWithCategoryAndAuthor() {
		return sessionFactory.getCurrentSession().
				getNamedQuery("Book.findAllWithCategoryAuthor").list();
	}

	@Transactional(readOnly = true)
	public Book findBookWithCategoryAndAuthorById(Long id) {
		return (Book) sessionFactory.getCurrentSession().
				getNamedQuery("Book.findBookWithCategoryAuthorById").
				setParameter("id", id).uniqueResult();
	}

	@Transactional(readOnly = true)
	public List<Book>  findBooksWithCategoryAndAuthorByAuthorId(Long id) {
		return sessionFactory.getCurrentSession().getNamedQuery("Book.findBooksWithCategoryAuthorByAuthorId").setParameter("id", id).list();
	}

	public Book save(Book book) {
		sessionFactory.getCurrentSession().saveOrUpdate(book);
		logger.info("Book saved with id: " + book.getId());
		return book;
	}

	public void delete(Book book) {
		sessionFactory.getCurrentSession().delete(book);
		logger.info("Book deleted with id: " + book.getId());
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	//Inject the SessionFactory
	@Resource(name = "sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
