package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.CommandeFournisseur;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;

@Data @Builder
public class LigneCommandeFournisseurDto {


    private Long id;
    private Article article ;


    private BigDecimal quantite ;
    private BigDecimal prixUnitaire ;
    private CommandeFournisseur commandeFournisseur ;
}
