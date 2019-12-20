package my.books.entities;


import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    private Long id;

    @NotBlank(message="{validation.categoryName.NotBlank.message}")
    @Size(min=2, max=100, message="{validation.categoryName.Size.message}")
    @Column(name = "CATEGORY_NAME")
    private String categoryName;

    @NotBlank(message="{validation.isbn.NotBlank.message}")
    @Size(min=10, max=10, message="{validation.isbn.Size.message}")
    @Column(name = "ISBN")
    private String isbn;

    @NotBlank(message="{validation.title.NotBlank.message}")
    @Size(min=2, max=200, message="{validation.title.Size.message}")
    @Column(name = "TITLE")
    private String title;

    @NotBlank(message="{validation.publisher.NotBlank.message}")
    @Size(min=2, max=100, message="{validation.publisher.Size.message}")
    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "PRICE")
    private Double price;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book - Id: " + id + ", Category: " + categoryName
                + ", ISBN: " + isbn + ", Title: " + title
                + ", Publisher: " + publisher + ", Price: " + price;
    }
}
