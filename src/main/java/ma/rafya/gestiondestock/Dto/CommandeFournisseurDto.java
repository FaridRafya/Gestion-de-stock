package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.entities.CommandeFournisseur;
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

    public static CommandeFournisseurDto fromEntity(CommandeFournisseur commandeFournisseur){
        return CommandeFournisseurDto.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .fournisseur(FournisseurDto.fromEntity(commandeFournisseur.getFournisseur()) )
                .dateCommande(commandeFournisseur.getDateCommande())
                .build() ;

    }

    public static CommandeFournisseur fromEntity(CommandeFournisseurDto commandeFournisseur){
        return CommandeFournisseur.builder()
                .id(commandeFournisseur.getId())
                .code(commandeFournisseur.getCode())
                .fournisseur(FournisseurDto.toEntity(commandeFournisseur.getFournisseur()) )
                .dateCommande(commandeFournisseur.getDateCommande())
                .build() ;

    }
}


