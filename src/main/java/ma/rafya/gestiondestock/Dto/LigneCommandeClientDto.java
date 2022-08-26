package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.CommandeClient;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data @Builder
public class LigneCommandeClientDto {

    private Long id;
    private ArticleDto article ;


    private BigDecimal quantite ;
    private BigDecimal prixUnitaire ;
    private CommandeClientDto commandeClient ;

}
