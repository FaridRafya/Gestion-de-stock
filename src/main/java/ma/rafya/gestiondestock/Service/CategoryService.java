package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Long id);

    CategoryDto findByCodeCategory(String code);

    List<CategoryDto> findall();

    void delete(Long id);
}
