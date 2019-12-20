package my.jdbc.crud;

import my.jdbc.domain.Category;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectAllCategory extends MappingSqlQuery<Category> {
    private static final String SQL_SELECT_ALL_CATEGORY =
        "select c.id, c.name from category c";

    public SelectAllCategory(DataSource dataSource) {

        super(dataSource, SQL_SELECT_ALL_CATEGORY);
    }

    protected Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        Category category = new Category();

        category.setId(rs.getLong("id"));
        category.setName(rs.getString("name"));

        return category;
    }
}
