package by.smuraha.market.controller.view;

import by.smuraha.market.ProductService;
import by.smuraha.market.dto.CartDto;
import by.smuraha.market.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ViewHomeController {

    private final ProductService productService;

    @Autowired
    public ViewHomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/home")
    public String getPage(HttpSession session, Model model){
        if(session.getAttribute("currentCart")==null){
            session.setAttribute("currentCart",new CartDto());
        }
        List<Product> all = productService.findAll();
        model.addAttribute("products",all);
        return "home";
    }
}
