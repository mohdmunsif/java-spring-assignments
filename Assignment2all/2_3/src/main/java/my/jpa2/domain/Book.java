package my.jpa2.domain;

import my.jpa2.domain.Category;
import my.jpa2.domain.Author;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
@NamedQueries({
        @NamedQuery(name= Book.FIND_ALL, query="select s from Book s"),
        @NamedQuery(name= Book.FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_ID,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.authors a " +
                        "where b.id = :id"),
        @NamedQuery(name= Book.FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.authors a " +
                        "where a.id = :id"),
        @NamedQuery(name= Book.FIND_ALL_WITH_CATEGORY_AUTHOR,
                query="select distinct b from Book b " +
                        "left join fetch b.category c " +
                        "left join fetch b.authors a")
})
@SqlResultSetMapping(
     name="bookResult",
     entities=@EntityResult(entityClass= Book.class)
)
public class Book implements Serializable {

    public static final String FIND_ALL = "Book.findAll";
    public static final String FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_ID =
    		"Book.findBookWithCategoryAuthorById";
    public static final String FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID =
    		"Book.findBookWithCategoryAuthorByAuthorId";
    public static final String FIND_ALL_WITH_CATEGORY_AUTHOR =
    		"Book.findAllWithCategoryAuthor";

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;
//
//    @Version
//    @Column(name = "VERSION")
//    private int version;

    @Column(name = "title")
    private String title;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToMany(cascade = {
            CascadeType.ALL
    })
    @JoinTable(name = "author_book",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName="id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName="id"))
    private Set<Author> authors = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public int getVersion() {
//        return version;
//    }
//
//    public void setVersion(int version) {
//        this.version = version;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return String.format("Book - id: %d, ISBN: %s, Title: %s, Price: %.2f",
                id, isbn, title, price );
    }
}
