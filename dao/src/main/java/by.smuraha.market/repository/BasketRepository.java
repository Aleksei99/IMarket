package by.smuraha.market.repository;

import by.smuraha.market.entity.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface BasketRepository extends CrudRepository<Basket,Long> {
    List<Basket> findAllByOrderID(Long id);
}
