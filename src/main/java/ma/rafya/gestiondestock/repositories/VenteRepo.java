package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.entities.Vente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenteRepo  extends JpaRepository<Vente,Long> {

    Vente findByCode(String code) ;
}
