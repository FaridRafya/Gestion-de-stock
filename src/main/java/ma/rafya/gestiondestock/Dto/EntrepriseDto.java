package ma.rafya.gestiondestock.Dto;
import lombok.Builder;
import lombok.Data;


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
}
