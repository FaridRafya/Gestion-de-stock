package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.Category;

import java.math.BigDecimal;

@Data @Builder
public class ArticleDto {

    private Long id;
    private String codeArticle;
    private String description;
    private BigDecimal prixUnitaireht;
    private BigDecimal tauxTva;
    private BigDecimal prixUnitaireTtc;
    private String photo;
    private CategoryDto category;


    public static  ArticleDto fromEntity(Article article){
        return ArticleDto.builder()
                .id(article.getId())
                .codeArticle(article.getCodeArticle())
                .description(article.getDescription())
                .prixUnitaireht(article.getPrixUnitaireht())
                .tauxTva(article.getTauxTva())
                .photo(article.getPhoto())
               .category(CategoryDto.fromEntity(article.getCategory()))
                .build() ;
    }
    public static Article toEntity(ArticleDto  dto){
        return Article.builder()
                .id(dto.getId())
                .codeArticle(dto.codeArticle)
                .description(dto.getDescription())
                .prixUnitaireht(dto.prixUnitaireht)
                .tauxTva(dto.getTauxTva())
                .photo(dto.getPhoto())
                .category(CategoryDto.toEntity( dto.getCategory()))
                .build() ;

    }
}
