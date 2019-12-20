package my.jpa2.data;

import my.jpa2.data.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> findWithCategoryAuthorById(Long id);
    Book save(Book book);
}
