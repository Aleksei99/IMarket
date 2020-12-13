package by.smuraha.market.controller;

import by.smuraha.market.ProductService;
import by.smuraha.market.BasketDto;
import by.smuraha.market.dto.CartDto;
import by.smuraha.market.FullOrderDto;
import by.smuraha.market.dto.OrderDTO;
import by.smuraha.market.entity.Order;
import by.smuraha.market.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    private final ProductService productService;

    @Autowired
    public CartController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/cart/add")
    public String addProductToCart(@RequestParam("productID") Long id, HttpSession session){
        if(session.getAttribute("currentCart")==null){
            session.setAttribute("currentCart",new CartDto());
        }
        Product product = productService.findProduct(id);
        CartDto currentCart = (CartDto) session.getAttribute("currentCart");
        currentCart.getProducts().add(product);
        session.setAttribute("currentCart",currentCart);
        Long subID = product.getSubcategory().getId();
        return "redirect:/products/" +subID;
    }

    @PostMapping("/cart/remove")
    public String removeProductFromCart(@RequestParam("productID") Long id, HttpSession session){
        Product product = productService.findProduct(id);
        CartDto currentCart = (CartDto) session.getAttribute("currentCart");
        currentCart.getProducts().remove(product);
        session.setAttribute("currentCart",currentCart);
        Long subID = product.getSubcategory().getId();
        return "redirect:/products/" +subID;
    }

    @PostMapping("/product/remove")
    public String removeFromCart(@RequestParam("productID") Long id, HttpSession session){
        Product product = productService.findProduct(id);
        CartDto currentCart = (CartDto) session.getAttribute("currentCart");
        currentCart.getProducts().remove(product);
        session.setAttribute("currentCart",currentCart);
        return "redirect:/cart/window";
    }

    @GetMapping("/cart/window")
    public String getCartPage(){
        return "cart";
    }
    @ModelAttribute("modelOrder")
    public OrderDTO modelOrder() {
        return new OrderDTO();
    }

    @PostMapping("/ordering")
    public String post(OrderDTO dto, HttpSession session) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        FullOrderDto order = new FullOrderDto();
        List<BasketDto> basketDtos = new ArrayList<>();
        for (int i = 0; i < dto.getCount().size(); i++) {
            for (int j = 0; j < dto.getPrice().size(); j++) {
                if (i == j) {
                    basketDtos.add(new BasketDto(dto.getIds().get(i),dto.getCount().get(i)));
                    totalAmount = totalAmount.add(new BigDecimal(dto.getCount().get(i)).multiply(dto.getPrice().get(j)));
                }
            }
        }
        order.setBaskets(basketDtos);
        order.setTotalSum(totalAmount);
        session.setAttribute("currentOrder",order);
        return "redirect:/ordering";
    }
}
