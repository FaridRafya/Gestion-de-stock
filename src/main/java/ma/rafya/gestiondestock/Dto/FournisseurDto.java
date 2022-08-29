package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Client;
import ma.rafya.gestiondestock.entities.CommandeFournisseur;
import ma.rafya.gestiondestock.entities.Fournisseur;

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

    public static  FournisseurDto fromEntity(Fournisseur client){
        return FournisseurDto.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .photo(client.getPhoto())
                .telephone(client.getTelephone())
                .build() ;
    }

    public static  Fournisseur toEntity(FournisseurDto client){
        return Fournisseur.builder()
                .id(client.getId())
                .nom(client.getNom())
                .prenom(client.getPrenom())
                .adresse(client.getAdresse())
                .photo(client.getPhoto())
                .telephone(client.getTelephone())
                .build() ;
    }
}


