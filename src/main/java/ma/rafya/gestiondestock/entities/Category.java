package ma.rafya.gestiondestock.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor  @Entity
public class Category  implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @CreatedDate
    @JsonIgnore
    private Date createdDate;

    @LastModifiedDate
    @JsonIgnore
    private Date lastModifiedDate;

    private String  codeCategory ;
    private String designation ;

    @OneToMany(mappedBy = "category")
    private List<Article> articles  ;
}
