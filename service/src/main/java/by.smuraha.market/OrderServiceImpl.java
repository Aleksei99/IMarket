package by.smuraha.market;

import by.smuraha.market.entity.Order;
import by.smuraha.market.entity.Product;
import by.smuraha.market.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

    @Override
    public Order save(FullOrderDto orderDto) {
        Order order = new Order();
        order.setUser(userService.getCurrentUser());
        order.setTimeOrder(new java.sql.Timestamp(new java.util.Date().getTime()));
        order.setTotalAmount(orderDto.getTotalSum());
        Set<Product> products = new HashSet<>();
        for (BasketDto item:orderDto.getBaskets()){
            products.add(productService.findProduct(item.getProductID()));
        }
        order.setProducts(products);
        return orderRepository.save(order);
    }

    @Override
    public List<Order> findUserOrders(Long id) {
        return orderRepository.findOrdersByUserId(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> findOrders(int hours) {
        return orderRepository.findAllWithTimeOrderAfter(new java.sql.Timestamp(new java.util.Date().getTime()-3600000*hours));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findOrderById(id);
    }

    @Override
    public BigDecimal getTotalAmount(Set<Product> products) {
        return null;
    }

    @Override
    public void update(Order order, BigDecimal totalAmount) {
        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
    }
}
