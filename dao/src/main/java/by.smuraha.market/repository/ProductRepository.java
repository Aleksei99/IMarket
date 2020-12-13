package by.smuraha.market.repository;

import by.smuraha.market.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findProductsBySubcategoryId(Long id);
    Product findProductById(Long id);
    List<Product> findAll();
}
