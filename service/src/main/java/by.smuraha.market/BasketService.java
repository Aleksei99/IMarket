package by.smuraha.market;

import by.smuraha.market.entity.Basket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BasketService {
    void save(FullOrderDto orderDto,Long id);
    List<Basket> findAllByOrderID(Long id);
}
