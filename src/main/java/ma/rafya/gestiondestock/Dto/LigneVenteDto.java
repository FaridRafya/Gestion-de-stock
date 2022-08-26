package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Vente;

import java.math.BigDecimal;
@Data @Builder
public class LigneVenteDto {
    private Long id;
    private VenteDto vente ;
    private ArticleDto articleDto ;

    private BigDecimal quantite ;
    private BigDecimal prixUnitaire ;
}
