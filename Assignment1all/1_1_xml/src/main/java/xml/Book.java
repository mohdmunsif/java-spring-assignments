package xml;

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


	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();

		Book book1 = (Book) ctx.getBean("book1");
		logger.info(book1.toString());

		Book book2 = (Book) ctx.getBean("book2");
		logger.info(book2.toString());

		Book book3 = (Book) ctx.getBean("book3");
		logger.info(book3.toString());

		Book book4 = (Book) ctx.getBean("book4");
		logger.info(book4.toString());

		ctx.close();
	}


	public String toString2() {
		return "id: " + id + "\n"
				+ "isbn: " + isbn + "\n"
				+ "title: " + title + "\n"
				+ "price: " + price  ;
	}
	public String toString() {
		return "id: " + id + ","
				+ "isbn: " + isbn + ","
				+ "title: " + title + ","
				+ "price: " + price  ;
	}
}
