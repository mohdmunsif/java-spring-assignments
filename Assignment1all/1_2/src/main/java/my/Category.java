package my;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class Category {
    private Long id;
    private String name;
    private Book book;

    public Category(Book book) {
        this.book = book;
        logger.info("calling Category.constructor()  === Autowiring byConstructor === ");
    }

    public Category() {
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

    public void setBook(Book book) {
        this.book = book;
        logger.info("calling setBook.setter() === Autowiring bySetter === ");
    }

    private static final Logger logger =
            LoggerFactory.getLogger(Category.class);

    public static void main(String... args) {


        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-byName.xml");
        ctx.refresh();

        Category poetry = (Category) ctx.getBean("poetry", Category.class);
        System.out.println("\n==========================Autowired by Name Output Start ===========================");
        Book tempBook = poetry.getBook();
        System.out.println(tempBook.toString());
        System.out.println("\n===========================Autowired by Name Output End ===========================\n");
        ctx.close();


        GenericXmlApplicationContext ctx2 = new GenericXmlApplicationContext();
        ctx2.load("classpath:spring/app-context-byType.xml");
        ctx2.refresh();

        Category novel = (Category) ctx2.getBean("novel", Category.class);
        System.out.println("\n==========================Autowired by Type Output Start ===========================");
        Book tempBook2 = novel.getBook();
        System.out.println(tempBook2.toString());
        System.out.println("\n===========================Autowired by Type Output End ===========================\n");
        ctx2.close();



        GenericXmlApplicationContext ctx3 = new GenericXmlApplicationContext();
        ctx3.load("classpath:spring/app-context-byConstructor.xml");
        ctx3.refresh();

        Category java = (Category) ctx3.getBean("java");
        System.out.println("\n==========================Autowired by Constructor Output Start ===========================\n");
        Book tempBook3 = java.getBook();
        System.out.println(tempBook3.toString());
        System.out.println("\n===========================Autowired by Constructor Output End ===========================");

        ctx3.close();



    }



}
