package my;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Book {
	private static final Logger logger = 
			LoggerFactory.getLogger(Book.class);

	private Long id;
	private String isbn;
	private String title;
	private Float price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String toString() {
		return "id: " + id + ","
				+ "isbn: " + isbn + ","
				+ "title: " + title + ","
				+ "price: " + price  ;
	}
}
