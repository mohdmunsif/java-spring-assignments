package my;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class CategorySetter {
    private Long id;
    private String name;
    private Book book;

    public CategorySetter(Book book) {
        this.book = book;
        logger.info("calling Category.constructor()  === Autowiring byConstructor === ");
    }

    public CategorySetter() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    @Autowired
    public void setBook(Book book) {
        this.book = book;
        logger.info("calling setBook.setter() === Autowiring bySetter === ");
    }

    private static final Logger logger =
            LoggerFactory.getLogger(CategorySetter.class);

    public static void main(String... args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-bySetter.xml");
        ctx.refresh();

        CategorySetter poetry = (CategorySetter) ctx.getBean("poetry", CategorySetter.class);
        System.out.println("\n==========================Autowired by Setter Output Start ===========================");
        Book tempBook = poetry.getBook();
        System.out.println(tempBook.toString());
        System.out.println("\n===========================Autowired by Setter Output End ===========================\n");
        ctx.close();

    }



}
