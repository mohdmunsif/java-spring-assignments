package my.hibernate.app;

import my.hibernate.config.AppConfig;
import my.hibernate.dao.BookDao;
import my.hibernate.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;


public class FindAllBookAuthorCategoriesByAuthorId {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBookAuthorCategoriesByAuthorId.class);

	public static void main(String... args) {
		GenericApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);

		logger.info("============== Find book with authors and category by ID start ==============");
		List<Book>  bookWithCategoryAuthorByAuthorId = bookDao.findBooksWithCategoryAndAuthorByAuthorId(1l);
		listBookWithCategoriesAuthors(bookWithCategoryAuthorByAuthorId);
		logger.info("============== Find book with authors and category by ID end ==============");

		ctx.close();
	}

	public static void listBookWithCategoriesAuthors(List<Book> books) {
		logger.info(" ---- Listing authors with category:");
		books.forEach(s -> {
			logger.info(s.toString());
			if (s.getAuthors() != null) {
				s.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
			}
			if (s.getCategory() != null) {
				logger.info("\tCategory: " + s.getCategory().toString() );
			}
		});
	}
}