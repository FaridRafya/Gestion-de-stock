package ma.rafya.gestiondestock.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class mvtstk implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Date createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedDate;

    private Instant dateMvt ;
    private BigDecimal quantite ;
    @ManyToOne
    @JoinColumn(name = "idArticle")
    private Article article;

}
