package by.smuraha.market;

import by.smuraha.market.entity.Category;
import by.smuraha.market.entity.Subcategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SubCategoryTest extends InitDbTest {

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void getSubCategoryTest(){
        Assert.assertEquals(subCategoryService.getSubCategory(1L).getName(),"subcategory");
    }

    @Test
    public void addSubcategoryTest(){
        subCategoryService.addSubCategory(new Subcategory(categoryService.getCategory(1L),"subcategory2"));
        Assert.assertEquals(subCategoryService.getAllSubCategories().size(),2);
    }
}
