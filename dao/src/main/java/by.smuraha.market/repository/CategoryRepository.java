package by.smuraha.market.repository;

import by.smuraha.market.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {
    Category findCategoryById(Long id);
    List<Category> findAll();
}
