package by.smuraha.market;

import by.smuraha.market.entity.Order;
import by.smuraha.market.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public interface OrderService {
    Order save(FullOrderDto orderDto);
    List<Order> findUserOrders(Long id);
    void save(Order order);
    List<Order> findOrders(int hours);
    List<Order> findAll();
    Order findById(Long id);
    BigDecimal getTotalAmount(Set<Product> products);
    void update(Order order, BigDecimal totalAmount);
}
