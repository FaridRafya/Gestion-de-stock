package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrepriseRepo extends JpaRepository <Entreprise,Long>{
}
