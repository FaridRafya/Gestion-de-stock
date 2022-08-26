package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Utilisateur;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.List;

@Data @Builder
public class RoleDto {
    private Long id;
    private String roleName ;
    private UtilisateurDto utilisateur ;


}
