package by.smuraha.market;

import by.smuraha.market.entity.Category;

import java.util.List;

public interface CategoryService {
    void addCategory(Category category);

    void deleteCategory(Long id);

    Category getCategory(Long id);

    List<Category> getAllCategories();
}
