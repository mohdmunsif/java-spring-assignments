package my.jpa2.app;

import my.jpa2.domain.Book;
import my.jpa2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class FindAllBooksWithCategoryAuthorDemo {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksWithCategoryAuthorDemo.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean(BookService.class);
        
        logger.info("============== Find all books with category and author start ==============");
        List<Book> books = bookService.findAllWithCategoryAuthor();
        llistBookWithCategoriesAuthors(books);
        logger.info("============== Find all books with category and author end ==============");
		
        ctx.close();
    }
    
    public static void llistBookWithCategoriesAuthors(List<Book> books) {
        logger.info(" ---- Listing authors with category:");
        books.forEach(s -> {
            logger.info(s.toString());
            if (s.getAuthors() != null) {
                s.getAuthors().forEach(a -> logger.info("\t" + a.toString()));
            }
            if (s.getCategory() != null) {
                logger.info("\t" + s.getCategory().toString() );
            }
        });
    }
}
