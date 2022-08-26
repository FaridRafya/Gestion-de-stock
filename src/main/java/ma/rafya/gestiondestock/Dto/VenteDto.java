package ma.rafya.gestiondestock.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data @Builder
public class VenteDto {
    private Long id;
    private String code ;
    private Instant dateVente ;
    private String commentaire ;

    private List<LigneVenteDto> ligneVenteDtos ;


}
