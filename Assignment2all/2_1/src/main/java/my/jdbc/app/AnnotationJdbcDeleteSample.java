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

public class AnnotationJdbcDeleteSample {
	private static Logger logger = LoggerFactory.getLogger(
			AnnotationJdbcDeleteSample.class);
	
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class);
		
		//delete the inserted book
		bookDao.delete(10L);

		List<Book> books = bookDao.findAll();
		AnnotationJdbcUtils.listBooks(books);
       
        ctx.close();
    }
}
