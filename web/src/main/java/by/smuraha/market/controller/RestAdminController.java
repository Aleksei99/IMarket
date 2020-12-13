package by.smuraha.market.controller;

import by.smuraha.market.CategoryService;
import by.smuraha.market.SubCategoryService;
import by.smuraha.market.dto.CategoryDto;
import by.smuraha.market.dto.IdDto;
import by.smuraha.market.dto.SubCategoryDto;
import by.smuraha.market.entity.Category;
import by.smuraha.market.entity.Subcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAdminController {
    private final SubCategoryService subCategoryService;
    private final CategoryService categoryService;

    @Autowired
    public RestAdminController(SubCategoryService subCategoryService, CategoryService categoryService) {
        this.subCategoryService = subCategoryService;
        this.categoryService = categoryService;
    }

    @PostMapping("/admin/addSubCategory")
    public SubCategoryDto addSubCategory(@RequestBody SubCategoryDto subCategoryDto) {
        Long id = subCategoryDto.getId();
        subCategoryService.addSubCategory(new Subcategory(categoryService.getCategory(id), subCategoryDto.getName()));
        return subCategoryDto;
    }
    @PostMapping("admin/deleteSubCategory")
    public IdDto deleteSubCategory(@RequestBody IdDto idDto){
        subCategoryService.deleteSubCategory(idDto.getId());
        return idDto;
    }
    @PostMapping("admin/deleteCategory")
    public IdDto deleteCategory(@RequestBody IdDto idDto){
        categoryService.deleteCategory(idDto.getId());
        return idDto;
    }
    @PostMapping("admin/addCategory")
    public CategoryDto addCategory(@RequestBody CategoryDto categoryDto){
        categoryService.addCategory(new Category(categoryDto.getName()));
        return categoryDto;
    }
}
