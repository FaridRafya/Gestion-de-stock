package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.entities.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeFournisseurRepo  extends JpaRepository<LigneCommandeFournisseur,Long> {
}
