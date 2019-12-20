package my.hibernate.domain;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 4/22/17.
   Wrote new Named Queries and comments: Vitaly Yurik, 7/1/18
 */
@Entity
@Table(name = "book")
@NamedQueries({
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
						"left join fetch b.authors a"),
		@NamedQuery(name= Book.FIND_BOOK_BY_ID,
				query="select distinct b from Book b " +
						"left join fetch b.category c " +
						"left join fetch b.authors a " +
						"where b.id = :id")
})
/**
	Book entity class. Note that id and version are defined by the superclass.
**/
public class Book extends AbstractEntity {

	public static final String FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_ID =
			"Book.findBookWithCategoryAuthorById";
	public static final String FIND_BOOK_WITH_CATEGORY_AUTHOR_BY_AUTHOR_ID =
			"Book.findBooksWithCategoryAuthorByAuthorId";
	public static final String FIND_ALL_WITH_CATEGORY_AUTHOR =
			"Book.findAllWithCategoryAuthor";
	public static final String FIND_BOOK_BY_ID = "Book.findById";

	@Column(name = "title")
	private String title;

	@Column(name = "isbn")
	private String isbn;

	@Column(name = "price")
	private Double price;

	/**
		The @JoinTable indicates the underlying join table that Hibernate should look for. The name
		is the join table’s name, joinColumns defines the column that is the foreign key to the BOOK table, and
		inverseJoinColumns defines the column that is the foreign key to the other side of the association (that is,
		the AUTHOR table).
	*/
	@ManyToMany(cascade = {
			CascadeType.ALL
	})
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "book_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName="id"))
	private Set<Author> authors = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;

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

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return String.format("Book - id: %d, ISBN: %s, Title: %s, Price: %.2f",
				id, isbn, title, price );
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Book book = (Book) o;
		if (title != null ? !title.equals(book.title) : book.title != null)
			return false;
		if (isbn != null ? !isbn.equals(book.isbn) : book.isbn != null)
			return false;
		return price != null ? price.equals(book.price) : book.price == null;
	}

	@Override public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (title != null ? title.hashCode() : 0);
		result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		return result;
	}
}
