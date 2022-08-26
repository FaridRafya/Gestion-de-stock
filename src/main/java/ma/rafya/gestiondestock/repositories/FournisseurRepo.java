package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepo extends JpaRepository<Fournisseur,Long> {
}
