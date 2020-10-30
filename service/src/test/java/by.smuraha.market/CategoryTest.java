package by.smuraha.market;

import by.smuraha.market.entity.Category;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CategoryTest extends InitDbTest{

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getCategoryTest(){
        Assert.assertNotNull(categoryService.getCategory(1L));
    }

    @Test
    public void deleteCategoryTest(){
        categoryService.deleteCategory(1L);
        Assert.assertNull(categoryService.getCategory(1L));
    }

    @Test
    public void addCategory(){
        categoryService.addCategory(new Category("New"));
        List<Category> allCategories = categoryService.getAllCategories();
        Assert.assertEquals(allCategories.size(),2);
    }
}
