package my.jpa2.app;

import my.jpa2.domain.Book;
import my.jpa2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class FindAllBooksDemo {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooksDemo.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean(BookService.class);
        
        logger.info("============== Find all books start ==============");
        List<Book> books = bookService.findAll();
        listBooks(books);
        logger.info("============== Find all books end ==============");
		
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books:");
		books.forEach(s -> logger.info(s.toString()));
   }
}
