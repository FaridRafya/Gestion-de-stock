package ma.rafya.gestiondestock.Dto;
import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Client;
import ma.rafya.gestiondestock.entities.Entreprise;


import javax.persistence.Embedded;

import java.util.List;
@Data @Builder
public class EntrepriseDto {



    private Long id;
    private String nom ;
    private String description ;
    private String adresse ;
    private String photo ;
    private String email ;
    private String telephone ;
    private String siteWeb ;

    private List<UtilisateurDto> utilisateurs ;


    public static  EntrepriseDto fromEntity(Entreprise entreprise){
        return EntrepriseDto.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .adresse(entreprise.getAdresse())
                .photo(entreprise.getPhoto())
                .telephone(entreprise.getTelephone())
                .email(entreprise.getEmail())
                .siteWeb(entreprise.getSiteWeb())
                .build() ;
    }

    public static  Entreprise toEntity(EntrepriseDto entreprise){
        return Entreprise.builder()
                .id(entreprise.getId())
                .nom(entreprise.getNom())
                .adresse(entreprise.getAdresse())
                .photo(entreprise.getPhoto())
                .telephone(entreprise.getTelephone())
                .email(entreprise.getEmail())
                .siteWeb(entreprise.getSiteWeb())
                .build() ;
    }
}
