package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.CommandeFournisseur;

import javax.persistence.OneToMany;
import java.util.List;
@Data @Builder
public class FournisseurDto {

    private Long id;
    private String nom ;
    private String prenom ;

    private String adresse ;
    private String photo ;
    private String email ;
    private String telephone ;


    private List<CommandeFournisseurDto> commandeFournisseurs ;
}


