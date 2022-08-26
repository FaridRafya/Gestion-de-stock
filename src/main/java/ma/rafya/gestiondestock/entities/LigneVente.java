package ma.rafya.gestiondestock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor @Builder
@AllArgsConstructor @Entity
public class LigneVente  implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Date createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedDate;

    @ManyToOne()
    @JoinColumn(name = "idVente")
    private Vente vente ;


    private BigDecimal quantite ;
    private BigDecimal prixUnitaire ;
}
