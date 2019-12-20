package my.hibernate.dao;

import my.hibernate.domain.Book;

import java.util.List;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
public interface BookDao {

	List<Book> findAll();
	
	Book findById(Long id);

	List<Book> findAllWithCategoryAndAuthor();

	Book findBookWithCategoryAndAuthorById(Long id);

	List<Book> findBooksWithCategoryAndAuthorByAuthorId(Long id);

	Book save(Book book);

	void delete(Book book);
}
