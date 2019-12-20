package my.jpa2.app;

import my.jpa2.domain.Book;
import my.jpa2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class FindBookWithCategoryAuthorByIDDemo {
	private static Logger logger = LoggerFactory.getLogger(FindBookWithCategoryAuthorByIDDemo.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean(BookService.class);
        
        logger.info("============== Find a book with category and author start ==============");
        Book book = bookService.findBookWithCategoryAuthorById(2L);
        listBookWithCategoriesAuthors(book);
        logger.info("============== Find a book with category and author end ==============");
		
        ctx.close();
    }
    
    public static void listBookWithCategoriesAuthors(Book book) {
        logger.info(" ---- Listing authors with category:");

        logger.info(book.toString());
        if (book.getAuthors() != null) {
            book.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
        }
        if (book.getCategory() != null) {
            logger.info("\t" + book.getCategory().toString() );
        }
    }
}
