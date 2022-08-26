package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.entities.LigneCommandeFournisseur;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Builder @Data
public class CommandeFournisseurDto {
    private Long id;
    private String code ;
    private Instant dateCommande ;


    private FournisseurDto fournisseur ;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurs ;
}


