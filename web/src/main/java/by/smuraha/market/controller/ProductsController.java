package by.smuraha.market.controller;

import by.smuraha.market.ProductService;
import by.smuraha.market.dto.CartDto;
import by.smuraha.market.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProductsController {

    private final ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{id}")
    public String getProductsBySubCategory(@PathVariable("id") Long id, Model model, HttpSession session){
        if(session.getAttribute("currentCart")==null){
            session.setAttribute("currentCart",new CartDto());
        }
        List<Product> products = productService.findProducts(id);
        model.addAttribute("products",products);
        return "products";
    }
    @GetMapping("/product/{id}")
    public String getProductPage(@PathVariable("id") Long id, Model model) {
        Product product = productService.findProduct(id);
        model.addAttribute("product", product);
        return "product";
    }
}
