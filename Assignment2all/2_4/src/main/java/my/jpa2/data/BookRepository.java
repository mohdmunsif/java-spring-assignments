package my.jpa2.data;

import my.jpa2.data.entities.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findWithCategoryAuthorById(Long id);
}
