package my.hibernate.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long authorId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "description")
	private String descr;

	/**
		The mapping is similar to the one for Book, but the joinColumns and
		inverseJoinColumns attributes are reversed to reflect the association.
	*/

	@ManyToMany(cascade = {
			CascadeType.ALL
	})
	@JoinTable(name = "author_book",
			joinColumns = @JoinColumn(name = "author_id", referencedColumnName="id"),
			inverseJoinColumns = @JoinColumn(name = "book_id",referencedColumnName="id"))
	private Set<Book> books = new HashSet<>();

	public Long getAuthorId() {
		return this.authorId;
	}

	public Set<Book> getBooks() {
		return this.books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}
//	@Override
//	public String toString() {
//		return "Author :" + getAuthorId();
//	}

	@Override
	public String toString() {
		return String.format("Author - id: %d, FirstName: %s, LastName: %s, Descr: %s",
				authorId, firstName, lastName, descr );
	}

}