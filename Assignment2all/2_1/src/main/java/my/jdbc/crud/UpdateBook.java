package my.jdbc.crud;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.SqlUpdate;

import javax.sql.DataSource;
import java.sql.Types;

public class UpdateBook extends SqlUpdate {
    private static final String SQL_UPDATE_BOOK =
        "update book set category_id=:category_id, title=:title, isbn=:isbn, price=:price where id=:id";

    public UpdateBook(DataSource dataSource) {
        super(dataSource, SQL_UPDATE_BOOK);
        super.declareParameter(new SqlParameter("category_id", Types.INTEGER));
        super.declareParameter(new SqlParameter("title", Types.VARCHAR));
        super.declareParameter(new SqlParameter("isbn", Types.VARCHAR));
        super.declareParameter(new SqlParameter("price", Types.DOUBLE));
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
    }
}
