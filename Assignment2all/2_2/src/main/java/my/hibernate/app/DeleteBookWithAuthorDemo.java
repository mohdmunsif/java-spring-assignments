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
import java.util.List;
import java.util.Set;

public class DeleteBookWithAuthorDemo {
    private static Logger logger = LoggerFactory.getLogger(
            DeleteBookWithAuthorDemo.class);

    public static void main(String... args) {

            GenericApplicationContext ctx =
                    new AnnotationConfigApplicationContext(AppConfig.class);
            BookDao bookDao = ctx.getBean(BookDao.class);

            logger.info("============== Delete book by ID start ==============");
            Long idDelete = 18L;
            Book singerDelete = bookDao.findById(idDelete);
            bookDao.delete(singerDelete);
            FindAllBookAuthorCategories.listBookWithCategoriesAuthors(
                    bookDao.findAllWithCategoryAndAuthor());
            logger.info("============== Delete book by ID end ==============");

            ctx.close();
    }
}