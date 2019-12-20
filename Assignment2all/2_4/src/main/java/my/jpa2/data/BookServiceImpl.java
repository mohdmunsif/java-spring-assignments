package my.jpa2.data;

import my.jpa2.data.entities.Book;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import com.google.common.collect.Lists;

@Service("springJpaBookService")
@Transactional
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Transactional(readOnly=true)
    public  List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Transactional(readOnly=true)
    public List<Book> findWithCategoryAuthorById(Long id) {
        return Lists.newArrayList(bookRepository.findWithCategoryAuthorById(id));
    }

    @Override
    public Book save(Book book) {
        return null;
    }
}
