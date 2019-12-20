package my.jdbc.domain;

import my.jdbc.domain.Book;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Category implements Serializable {

	private Long id;
	private String name;
	private List<Book> books;

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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public boolean addBook(Book book) {
		if (books == null) {
			books = new ArrayList<>();
			books.add(book);
			return true;
		} else {
			if (books.contains(book)) {
				return false;
			}
		}
		books.add(book);
		return true;
	}

	public String toString() {
		return "Category - Id: " + id + ", Type: " + name ;
	}
}
