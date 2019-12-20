package my.jdbc.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import my.jdbc.dao.JdbcBookDao;
import my.jdbc.dao.BookDao;
import my.jdbc.domain.Book;

import my.jdbc.utils.AnnotationJdbcUtils;
import my.jdbc.config.AppConfig;


public class AnnotationJdbcFindAllSample {
	private static Logger logger = LoggerFactory.getLogger(
			AnnotationJdbcFindAllSample.class);
	
    public static void main(String[] args) {
	    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean("bookDao", JdbcBookDao.class);
		List<Book> books = bookDao.findAll();
        AnnotationJdbcUtils.listBooks(books);
        ctx.close();
    }
}
