package ma.rafya.gestiondestock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor  @Entity
@EntityListeners(AuditingEntityListener.class)
public class Article implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Date createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedDate;

    private String  codeArticle ;
    private String description ;
    private BigDecimal prixUnitaireht ;
    private BigDecimal tauxTva ;
    private BigDecimal prixUnitaireTtc ;
    private String photo ;
    @ManyToOne
    @JoinColumn(name = "idCategory")
    private Category category ;
}
