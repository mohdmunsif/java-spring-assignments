package my.hibernate.app;

import my.hibernate.config.AppConfig;
import my.hibernate.dao.BookDao;
import my.hibernate.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;


public class FindAllBooksDemo {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBooksDemo.class);

	public static void main(String... args) {
		GenericApplicationContext ctx = 
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);
		
		logger.info("============== Find all books start ==============");
		List<Book> booksAll = bookDao.findAll();
		listBooks(booksAll);
		logger.info("============== Find all books end ==============");
		
		ctx.close();
	}
	
	private static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books:");
		for (Book book : books) {
			logger.info(book.toString());
		}
	}
			
}