package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Utilisateur;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class UtilisateurDto {
    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String dateNAissance;
    private String motDePass;
    private String adresse;
    private String photo;

    private EntrepriseDto entreprise;

    private List<RoleDto> roles;

    public UtilisateurDto fromEntity(Utilisateur utilisateur){
        if (utilisateur== null){
            return null ;
        }
        return  UtilisateurDto.builder()
                .id(utilisateur.getId())
                .nom(utilisateur.getNom())
                .prenom(utilisateur.getPrenom())
                .email(utilisateur.getEmail())
                .dateNAissance(utilisateur.getDateNAissance())
                .motDePass(utilisateur.getMotDePass())
                .adresse(utilisateur.getAdresse())
                .photo(utilisateur.getPhoto())
             /*  .roles(
                       utilisateur.getRoles() !=null ?
                              utilisateur.getRoles().stream()
                                      .map(RoleDto::fromEntity)
                                        .collect(Collectors.toList()) : null   )*/
                .build();
    }
}
