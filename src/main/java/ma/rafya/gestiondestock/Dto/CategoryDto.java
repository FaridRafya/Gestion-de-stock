package ma.rafya.gestiondestock.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Category;

import java.util.List;

@Data @Builder
public class CategoryDto {
    private Long id;
    private String  codeCategory ;
    private String designation ;

     @JsonIgnore
    private List<ArticleDto> articles  ;


    public static CategoryDto fromEntity(Category category){

        if(category == null)
            return null ;

        return CategoryDto.builder()
                .id(category.getId())
                .codeCategory(category.getCodeCategory())
                .designation(category.getDesignation()).build()
                ;
    }
    public static  Category toEntity(CategoryDto cAtegoryDto){
        if(cAtegoryDto==null)
            return null;
    return Category.builder()
            .id(cAtegoryDto.getId())
            .codeCategory(cAtegoryDto.getCodeCategory())
            .designation(cAtegoryDto.getDesignation()).build() ;
    }
}
