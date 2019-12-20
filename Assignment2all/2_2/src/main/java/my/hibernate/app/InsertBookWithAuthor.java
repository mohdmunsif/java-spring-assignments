package my.hibernate.app;

import my.hibernate.config.AppConfig;
import my.hibernate.dao.BookDao;
import my.hibernate.domain.Author;
import my.hibernate.domain.Book;
import my.hibernate.domain.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.HashSet;
import java.util.Set;
import java.util.List;

public class InsertBookWithAuthor {
    private static Logger logger = LoggerFactory.getLogger(
            InsertBookWithAuthor.class);

    public static void main(String... args) {
        GenericApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppConfig.class);
        BookDao bookDao = ctx.getBean(BookDao.class);

        logger.info("============== Insert book with author start ==============");
        Book book = new Book();

        Category cat = new Category();

        cat.setId(1l);

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

        bookDao.save(book);

        List<Book> books = bookDao.findAllWithCategoryAndAuthor();
        FindAllBookAuthorCategories.listBookWithCategoriesAuthors(books);
        logger.info("============== Insert book with author end ==============");

        ctx.close();
    }
}