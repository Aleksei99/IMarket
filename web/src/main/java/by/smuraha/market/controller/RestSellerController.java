package by.smuraha.market.controller;

import by.smuraha.market.ProductService;
import by.smuraha.market.SubCategoryService;
import by.smuraha.market.UserService;
import by.smuraha.market.dto.ProductDto;
import by.smuraha.market.entity.Product;
import by.smuraha.market.entity.Subcategory;
import by.smuraha.market.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestSellerController {

    private final UserService userService;
    private final ProductService productService;
    private final SubCategoryService subCategoryService;

    @Autowired
    public RestSellerController(UserService userService, ProductService productService, SubCategoryService subCategoryService) {
        this.userService = userService;
        this.productService = productService;
        this.subCategoryService = subCategoryService;
    }

    @PostMapping("/seller/addProduct")
    public ProductDto saveProduct(@RequestBody ProductDto product) {
        User user = userService.getCurrentUser();
        Subcategory subcategory = subCategoryService.getSubCategory(product.getSubCategoryID());
        productService.save(new Product(product.getBrand(), product.getName(), product.getPrice(), subcategory, user, product.getDescription()));
        return product;
    }
}
