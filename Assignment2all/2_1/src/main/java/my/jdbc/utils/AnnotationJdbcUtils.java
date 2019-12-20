package my.jdbc.utils;

import java.util.List;
import java.util.GregorianCalendar;
import java.sql.Date;

import my.jdbc.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import my.jdbc.domain.Book;

public class AnnotationJdbcUtils {
	private static Logger logger = LoggerFactory.getLogger(
			AnnotationJdbcUtils.class);
	
	public static void listBooks(List<Book> books){
		books.forEach(book -> {
			logger.info(book.toString());

		});
	}
	public static void listCategories(List<Category> categories){
		categories.forEach(category -> {
			logger.info(category.toString());

		});
	}
}