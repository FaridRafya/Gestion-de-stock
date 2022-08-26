package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.entities.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface LigneVenteRepo extends JpaRepository<LigneVente,Long> {
}
