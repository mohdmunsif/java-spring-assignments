package my.hibernate.app;

import my.hibernate.config.AppConfig;
import my.hibernate.dao.BookDao;
import my.hibernate.domain.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;


public class FindAllBookAuthorCategoriesById {
	private static Logger logger = LoggerFactory.getLogger(
			FindAllBookAuthorCategoriesById.class);

	public static void main(String... args) {
		GenericApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppConfig.class);
		BookDao bookDao = ctx.getBean(BookDao.class);

		logger.info("============== Find book with authors and category by ID start ==============");
		Book bookWithCategoryAuthorById = bookDao.findBookWithCategoryAndAuthorById(1l);
		listBookWithCategoriesAuthors(bookWithCategoryAuthorById);
		logger.info("============== Find book with authors and category by ID end ==============");

		ctx.close();
	}

	public static void listBookWithCategoriesAuthors(Book book) {
		logger.info(" ---- Listing authors with category:");

			logger.info(book.toString());
			if (book.getAuthors() != null) {
				book.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
			}
			if (book.getCategory() != null) {
				 logger.info("\tCategory: " + book.getCategory().toString() );
			}

	}
}