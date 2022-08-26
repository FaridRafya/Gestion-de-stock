package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Client;
import ma.rafya.gestiondestock.entities.LigneCommandeClient;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data @Builder
public class CommandeClientDto {

    private Long id;

    private String code ;
    private ClientDto client ;
    private Instant dateCommande ;
    private List<LigneCommandeClientDto> ligneCommandeClients ;
}


