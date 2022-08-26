package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.CategoryDto;
import ma.rafya.gestiondestock.Service.CategoryService;
import ma.rafya.gestiondestock.entities.Category;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.CategoryRepository;
import ma.rafya.gestiondestock.validator.CategoryValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CategoryServiceImpl implements CategoryService {


    private CategoryRepository categoryRepository ;
    private ModelMapper modelMapper ;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        List<String> errors = CategoryValidator.validate(categoryDto) ;
        if(!errors.isEmpty()){
            throw new InvalidEntityException("category n'est pas valide", ErrorCode.CATEGORY_NOT_FOUND,errors);
        }

        Category category= modelMapper.map(categoryDto,Category.class) ;
         Category category1=       categoryRepository.save(category) ;
        return modelMapper.map(category1,CategoryDto.class);
    }

    @Override
    public CategoryDto findById(Long id) {
        if (id==null) return null ;

        Optional<Category> category =categoryRepository.findById(id) ;
        return Optional.of(modelMapper.map(category,CategoryDto.class)).orElseThrow(()->
                new EntityNotFoundException("category n'est pas trouvé")  ) ;
    }

    @Override
    public CategoryDto findByCodeCategory(String code) {
        if(!StringUtils.hasLength(code)){
            return  null ;
        }
        Category category = categoryRepository.findByCodeCategory(code) ;

        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public CategoryDto findall() {

        return (CategoryDto) categoryRepository.findAll().stream().map
                (e->modelMapper.map(e,CategoryDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

       categoryRepository.deleteById(id);
    }
}
