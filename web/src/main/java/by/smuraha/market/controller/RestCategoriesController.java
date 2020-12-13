package by.smuraha.market.controller;

import by.smuraha.market.CategoryService;
import by.smuraha.market.SubCategoryService;
import by.smuraha.market.dto.CategoryDto;
import by.smuraha.market.dto.SubCategoryDto;
import by.smuraha.market.entity.Category;
import by.smuraha.market.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestCategoriesController {

    private final CategoryService categoryService;
    private final SubCategoryService subCategoryService;

    @Autowired
    public RestCategoriesController(CategoryService categoryService, SubCategoryService subCategoryService) {
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
    }

    @GetMapping("/getCategories")
    public List<CategoryDto> getCategories() {
        List<Category> categoryList = categoryService.getAllCategories();
        List<CategoryDto> categories = categoryList
                .stream()
                .map(category -> new CategoryDto(category.getId(),category.getName()))
                .collect(Collectors.toList());
        return categories;
    }

    @GetMapping("/getSubCategories")
    public List<SubCategoryDto> getSubCategories(){
        List<Subcategory> subcategoryList = subCategoryService.getAllSubCategories();
        List<SubCategoryDto> categories = subcategoryList
                .stream()
                .map(subcategory -> new SubCategoryDto(subcategory.getId(),subcategory.getName(),subcategory.getCategory().getId()))
                .collect(Collectors.toList());
        return categories;
    }
}
