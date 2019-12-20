package my.jdbc.dao;

import java.util.List;
import my.jdbc.domain.Book;
import my.jdbc.domain.Category;

public interface BookDao {
    public List<Book> findAll();
    public List<Book> findByCategory(String category);
    public List<Category> findAllCategory();
    public void insert(Book book);
    public void update(Book book);
    public void delete(Long bookId);
}