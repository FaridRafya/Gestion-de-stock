package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Article;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.Instant;

@Data   @Builder
public class mvtstkDto {
    private Long id;
    private Instant dateMvt ;
    private BigDecimal quantite ;

    private ArticleDto article;
}
