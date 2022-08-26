package ma.rafya.gestiondestock.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.lang.model.element.Name;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor  @Entity
public class LigneCommandeClient  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreatedDate
    @JsonIgnore
    private Date createdDate;
    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedDate;

    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article ;

    @ManyToOne
    @JoinColumn(name = "idCommandeClient")
    private CommandeClient commandeClient ;

    private BigDecimal quantite ;
    private BigDecimal prixUnitaire ;


}
