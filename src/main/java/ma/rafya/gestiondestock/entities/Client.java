package ma.rafya.gestiondestock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data @Builder
@NoArgsConstructor
@AllArgsConstructor @Entity
public class Client  implements Serializable {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Date createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedDate;

    private String nom ;
    private String prenom ;

    private String adresse ;
    private String photo ;
    private String email ;
    private String telephone ;
    @OneToMany(mappedBy = "client")
    private List<CommandeClient> commandeClients ;
}
