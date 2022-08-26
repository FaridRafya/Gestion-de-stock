package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.LigneCommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepo extends JpaRepository<LigneCommandeClient,Long> {
}
