package rifqimuhammadaziz.springrestapiblog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rifqimuhammadaziz.springrestapiblog.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
