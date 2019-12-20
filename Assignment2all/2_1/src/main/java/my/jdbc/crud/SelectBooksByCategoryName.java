package my.jdbc.crud;

import my.jdbc.domain.Book;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class SelectBooksByCategoryName extends MappingSqlQuery<Book> {
    private static final String SQL_FIND_BY_CATEGORY =
        "select b.id, b.category_id, b.title, b.isbn, b.price from book b inner join category c on c.id = b.category_id where c.name =  :name";

    public SelectBooksByCategoryName(DataSource dataSource) {
        super(dataSource, SQL_FIND_BY_CATEGORY);
        super.declareParameter(new SqlParameter("name", Types.VARCHAR));
    }

    protected Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        Book book = new Book();

        book.setId(rs.getLong("id"));
        book.setCategoryId(rs.getLong("category_id"));
        book.setIsbn(rs.getString("isbn"));
        book.setTitle(rs.getString("title"));
        book.setPrice(rs.getDouble("price"));

        return book;
    }
}
