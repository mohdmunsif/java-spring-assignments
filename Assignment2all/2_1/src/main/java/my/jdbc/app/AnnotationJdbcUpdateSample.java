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


public class AnnotationJdbcUpdateSample {
	private static Logger logger = LoggerFactory.getLogger(
			AnnotationJdbcUpdateSample.class);
	
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class);
        Book book = new Book();
		book.setId(1L);
		book.setTitle("This Too Shall Pass ~~~~~~~ NOT!!! ");
		book.setIsbn("987654321");
		book.setCategoryId(3l);
		book.setPrice(14.12);

		bookDao.update(book);

		List<Book> books = bookDao.findAll();
		AnnotationJdbcUtils.listBooks(books);
        ctx.close();
    }
    
    
}
