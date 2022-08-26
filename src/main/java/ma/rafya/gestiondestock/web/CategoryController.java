package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.CategoryDto;
import ma.rafya.gestiondestock.Service.CategoryService;
import ma.rafya.gestiondestock.web.api.CategoryApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController implements CategoryApi {


    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Long id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
        return categoryService.findByCodeCategory(code);
    }

    @Override
    public CategoryDto findall() {
        return categoryService.findall();
    }

    @Override
    public void delete(Long id) {

        categoryService.delete(id);
    }
}
