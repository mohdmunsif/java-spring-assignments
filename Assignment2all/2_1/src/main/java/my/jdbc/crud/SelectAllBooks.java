package my.jdbc.crud;

import my.jdbc.domain.Book;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllBooks extends MappingSqlQuery<Book> {
    private static final String SQL_SELECT_ALL_BOOK =
        "select b.id, b.category_id, b.title, b.isbn, b.price from book b";

    public SelectAllBooks(DataSource dataSource) {
        super(dataSource, SQL_SELECT_ALL_BOOK);
    }

    protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setCategoryId(rs.getLong("category_id"));
        book.setTitle(rs.getString("title"));
        book.setIsbn(rs.getString("isbn"));
        book.setPrice(rs.getDouble("price"));

        return book;
    }
}
