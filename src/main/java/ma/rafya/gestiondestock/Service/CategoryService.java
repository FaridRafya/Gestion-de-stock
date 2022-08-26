package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.CategoryDto;

public interface CategoryService {

    CategoryDto save(CategoryDto categoryDto);

    CategoryDto findById(Long id);

    CategoryDto findByCodeCategory(String code);

    CategoryDto findall();

    void delete(Long id);
}
