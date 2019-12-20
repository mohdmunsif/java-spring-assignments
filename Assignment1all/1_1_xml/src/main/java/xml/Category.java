package xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.*;

public class Category {
    private Long id;
    private String name;
    private Set<Book> booksSet;
    private List<Book> booksList;
    private Map<String, Book> booksMap;

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

    public Set<Book> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<Book> booksSet) {
        this.booksSet = booksSet;
    }

    public List<Book> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Book> booksList) {
        this.booksList = booksList;
    }

    public Map<String, Book> getBooksMap() {
        return booksMap;
    }

    public void setBooksMap(Map<String, Book> booksMap) {
        this.booksMap = booksMap;
    }


    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-xml.xml");
        ctx.refresh();

        Category novels = (Category) ctx.getBean("novels");
        System.out.println("\n===========================Books List Output Start ===========================");
        for (Book temp : novels.getBooksList()) {
            System.out.println(temp.toString());
        }
        System.out.println("\n===========================Books List Output End ===========================");


        Category poetry = (Category) ctx.getBean("poetry");
        System.out.println("\n===========================Books Map Output Start ===========================");

        poetry.getBooksMap().forEach((k, v) -> {
            System.out.format("key: %s, value: %s%n", k, v.toString());
        });
        System.out.println("\n===========================Books Map Output End ===========================");

        Category java = (Category) ctx.getBean("java");
        System.out.println("\n===========================Books Set Output Start ===========================");

        for(Book onebook : java.getBooksSet() ){
            System.out.println( onebook.toString());
        }

        System.out.println("\n===========================Books Set Output End ===========================");

        ctx.close();
    }



}
