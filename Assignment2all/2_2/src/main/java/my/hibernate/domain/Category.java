package my.hibernate.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iuliana.cosmina on 4/21/17.
 */
@Entity
@Table(name = "category")
public class Category extends AbstractEntity {


	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Book> books = new HashSet<>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return String.format("Category - id: %d, Cat Type: %s",
				id, name );
	}

	@Override public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		if (!super.equals(o))
			return false;
		Category category = (Category) o;
		return name != null ? name.equals(category.name) : category.name == null;
	}

	@Override public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (name != null ? name.hashCode() : 0);
		return result;
	}
}
