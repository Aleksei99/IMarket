package by.smuraha.market;

import by.smuraha.market.entity.Subcategory;
import by.smuraha.market.repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

    private final SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryServiceImpl(SubCategoryRepository subCategoryRepository) {
        this.subCategoryRepository = subCategoryRepository;
    }

    @Override
    public void addSubCategory(Subcategory subcategory) {
        subCategoryRepository.save(subcategory);
    }

    @Override
    public void deleteSubCategory(Long id) {
        subCategoryRepository.deleteById(id);
    }

    @Override
    public List<Subcategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }

    @Override
    public List<Subcategory> getAllByCategoryID(Long id) {
        return subCategoryRepository.findAllByCategoryId(id);
    }

    @Override
    public Subcategory getSubCategory(Long id) {
        return subCategoryRepository.findSubcategoryById(id);
    }
}
