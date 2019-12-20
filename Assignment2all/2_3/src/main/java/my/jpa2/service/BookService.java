package my.jpa2.service;

import my.jpa2.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll();
    List<Book> findAllWithCategoryAuthor();
    Book findBookWithCategoryAuthorById(Long id);
    Book findBookWithCategoryAuthorByAuthorId(Long id);
    Book save(Book book);
    void delete(Book book);
    List<Book> findAllByNativeQuery();
}
