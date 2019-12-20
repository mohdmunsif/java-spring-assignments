package my.jpa2.data;

import my.jpa2.data.entities.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class SpringDataJpaApp {
	private static Logger logger = LoggerFactory.getLogger(SpringDataJpaApp.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean("springJpaBookService", BookService.class);
        listBooks("Find all:", bookService.findAll());
        listBooks("Find book by ID (1):", bookService.findWithCategoryAuthorById(1l));

    }

    private static void listBooks(String message, List<Book> books) {
        logger.info("");
        logger.info(message);
        for (Book book: books) {
            logger.info(book.toString());
        }
    }
}
