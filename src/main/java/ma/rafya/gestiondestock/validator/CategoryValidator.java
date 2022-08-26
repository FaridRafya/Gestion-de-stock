package ma.rafya.gestiondestock.validator;

import ma.rafya.gestiondestock.Dto.CategoryDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CategoryValidator {

    public static List<String> validate(CategoryDto categoryDto){
        List<String> errors= new ArrayList<>() ;

        if(categoryDto ==null ||!StringUtils.hasLength(categoryDto.getCodeCategory())){
      errors.add("veullez rensigner le code category ");}
        return errors ;
    }
}
