package my.jdbc.domain;


import java.io.Serializable;

public class Book implements Serializable {

	private Long id;
	private Long categoryId;
	private String title;
	private String isbn;
	private double price;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book - Id: " + id + ", ISBN: " + isbn +", Category id: " + categoryId
				+ ", Title: " + title + ", Price: " + price;
	}
}
