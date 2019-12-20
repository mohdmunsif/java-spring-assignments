package my.jdbc.app;

import my.jdbc.config.AppConfig;
import my.jdbc.dao.BookDao;
import my.jdbc.dao.JdbcBookDao;
import my.jdbc.domain.Category;
import my.jdbc.domain.Book;
import my.jdbc.utils.AnnotationJdbcUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;


public class AnnotationJdbcFindAllCatSample {
	private static Logger logger = LoggerFactory.getLogger(
			AnnotationJdbcFindAllCatSample.class);
	
    public static void main(String[] args) {
	    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class);
		List<Category> categories = bookDao.findAllCategory();
        AnnotationJdbcUtils.listCategories(categories);
        ctx.close();
    }
}
