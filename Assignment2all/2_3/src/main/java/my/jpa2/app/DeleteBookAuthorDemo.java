package my.jpa2.app;

import my.jpa2.domain.Author;
import my.jpa2.domain.Book;
import my.jpa2.domain.Category;
import my.jpa2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteBookAuthorDemo {
	private static Logger logger = LoggerFactory.getLogger(DeleteBookAuthorDemo.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean(BookService.class);

        logger.info("============== Delete book by ID start ==============");

        Long idDelete = 10L;
        Book singerDelete = bookService.findBookWithCategoryAuthorById(idDelete);
        bookService.delete(singerDelete);
        FindAllBooksDemo.listBooks(bookService.findAll());

        logger.info("============== Delete book by ID end ==============");
        ctx.close();
    }

}
