package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;
import ma.rafya.gestiondestock.entities.Client;
import ma.rafya.gestiondestock.entities.CommandeClient;
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


    public static CommandeClientDto fromEntity(CommandeClient commandeClient){
    return CommandeClientDto.builder()
            .id(commandeClient.getId())
            .code(commandeClient.getCode())
            .client(ClientDto.fromEntity(commandeClient.getClient()) )
            .dateCommande(commandeClient.getDateCommande())
            .build() ;

    }

    public static CommandeClient toEntity(CommandeClientDto commandeClient){
        return CommandeClient.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .client(ClientDto.toEntity(commandeClient.getClient()) )
                .dateCommande(commandeClient.getDateCommande())
                .build() ;

    }
}


