package my.jpa2.app;

import my.jpa2.domain.Book;
import my.jpa2.domain.Author;
import my.jpa2.domain.Category;
import my.jpa2.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InsertBookWithAuthor {
	private static Logger logger = LoggerFactory.getLogger(InsertBookWithAuthor.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();

        BookService bookService = ctx.getBean(BookService.class);
        
        logger.info("============== Insert a book with category and author start ==============");
        Book book = new Book();

        Category cat = new Category();

        cat.setCategoryId(1l);

        book.setCategory(cat);
        book.setIsbn("123441133");
        book.setTitle("This is a new book with Author");
        book.setPrice(44.22);

        Author author = new Author();
        author.setDescr("New unknown author to be honest");
        author.setFirstName("Brand");
        author.setLastName("New");

        Set<Author> authors = new HashSet<Author>() ;
        authors.add(author);
        book.setAuthors(authors);


        bookService.save(book);

        List<Book> books = bookService.findAll();
        FindAllBooksDemo.listBooks(books);

        logger.info("============== Insert a book with category and author end ==============");
		
        ctx.close();
    }

}
