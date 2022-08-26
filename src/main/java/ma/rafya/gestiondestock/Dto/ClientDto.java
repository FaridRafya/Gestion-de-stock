package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.CommandeClient;

import javax.persistence.OneToMany;
import java.util.List;

@Data @Builder
public class ClientDto {
    private Long id;

    private String nom ;
    private String prenom ;

    private String adresse ;
    private String photo ;
    private String email ;
    private String telephone ;

    private List<CommandeClientDto> commandeClients ;
}
