package by.smuraha.market;

import by.smuraha.market.entity.Basket;
import by.smuraha.market.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketServiceImpl implements BasketService{
    private final BasketRepository basketRepository;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }

    @Override
    public void save(FullOrderDto orderDto,Long id) {
        for (BasketDto product:orderDto.getBaskets()) {
            basketRepository.save(new Basket(id, product.getProductID(), product.getCount()));
        }
    }

    @Override
    public List<Basket> findAllByOrderID(Long id) {
        return basketRepository.findAllByOrderID(id);
    }
}
