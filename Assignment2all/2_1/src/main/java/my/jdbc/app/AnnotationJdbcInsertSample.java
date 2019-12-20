package my.jdbc.app;

import java.util.List;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.jdbc.config.AppConfig;
import my.jdbc.dao.BookDao;
import my.jdbc.dao.JdbcBookDao;
import my.jdbc.domain.Book;

import my.jdbc.utils.AnnotationJdbcUtils;

public class AnnotationJdbcInsertSample {
	private static Logger logger = LoggerFactory.getLogger(
			AnnotationJdbcInsertSample.class);
	
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class);
		
		Book book = new Book();
		book.setTitle("This Too Shall Pass");
		book.setIsbn("1234568917");
		book.setCategoryId(2l);
		book.setPrice(11.11);

		bookDao.insert(book);

		List<Book> books = bookDao.findAll();
		AnnotationJdbcUtils.listBooks(books);
       
        ctx.close();
    }
}
