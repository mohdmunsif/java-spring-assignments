package my.jdbc.dao;

import my.jdbc.crud.*;
import my.jdbc.domain.Book;
import my.jdbc.domain.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("bookDao")
public class JdbcBookDao implements BookDao {

	private static Logger logger = LoggerFactory.getLogger(JdbcBookDao.class);
	private DataSource dataSource;
	private SelectAllBooks selectAllBooks;
	private SelectAllCategory selectAllCategory;
	private SelectBooksByCategoryName selectBooksByCategoryName;
	private UpdateBook updateBook;
	private InsertBook insertBook;
	private DeleteBook deleteBook;


	@Override
	public List<Book> findAll() {
		return selectAllBooks.execute();
	}

	@Override
	public List<Book> findByCategory(String catName) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("name", catName);
		return selectBooksByCategoryName.executeByNamedParam(paramMap);
	}

	@Override
	public List<Category> findAllCategory() {
		logger.info("findAllCategory"  );
		return selectAllCategory.execute();
	}

	@Override
	public void insert(Book book) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("title", book.getTitle());
		paramMap.put("isbn", book.getIsbn());
		paramMap.put("category_id", book.getCategoryId());
		paramMap.put("price", book.getPrice());
		KeyHolder keyHolder = new GeneratedKeyHolder();
		insertBook.updateByNamedParam(paramMap, keyHolder);
		book.setId(keyHolder.getKey().longValue());
		logger.info("New book inserted with id: " + book.getId());
	}


	@Override
	public void update(Book book) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("title", book.getTitle());
		paramMap.put("isbn", book.getIsbn());
		paramMap.put("category_id", book.getCategoryId());
		paramMap.put("price", book.getPrice());
		paramMap.put("id", book.getId());
		updateBook.updateByNamedParam(paramMap);
		logger.info("Existing book updated with id: " + book.getId());
	}
	
	
	@Override public void delete(Long bookId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", bookId);
		deleteBook.updateByNamedParam(paramMap);
		logger.info("Deleting book with id: " + bookId);
	}

	@Resource(name = "dataSource")
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.selectAllBooks = new SelectAllBooks(dataSource);
		this.selectAllCategory = new SelectAllCategory(dataSource);
		this.selectBooksByCategoryName = new SelectBooksByCategoryName(dataSource);
		this.updateBook = new UpdateBook(dataSource);
		this.insertBook = new InsertBook(dataSource);
		this.deleteBook = new DeleteBook(dataSource);
	}

	public DataSource getDataSource() {
		return dataSource;
	}
}
