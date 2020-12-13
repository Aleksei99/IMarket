package by.smuraha.market.repository;

import by.smuraha.market.entity.Subcategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface SubCategoryRepository extends CrudRepository<Subcategory,Long> {
    List<Subcategory> findAllByCategoryId(Long id);
    Subcategory findSubcategoryById(Long id);
    List<Subcategory> findAll();
    void deleteSubcategoryById(Long id);
}
