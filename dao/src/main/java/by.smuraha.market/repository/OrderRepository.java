package by.smuraha.market.repository;

import by.smuraha.market.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Repository
@Transactional
public interface OrderRepository extends CrudRepository<Order,Long> {
    @Query("select o from Order o where o.timeOrder >= :timeOrder and o.totalAmount is not null and o.statement not like 'DELIVERED'")
    List<Order> findAllWithTimeOrderAfter(@Param("timeOrder") Timestamp timeOrder);
    @Query("select o from Order o where o.statement not like 'DELIVERED'")
    List<Order> findAll();
    Order findOrderById(Long id);
    List<Order> findOrdersByUserId(Long id);
}
