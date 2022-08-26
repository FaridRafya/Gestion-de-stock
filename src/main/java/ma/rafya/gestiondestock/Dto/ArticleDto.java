package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;

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
    private CategoryDto categoryDto;


}
