package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilisateurRepo  extends JpaRepository<Utilisateur,Long> {

  Optional<Utilisateur>  findByEmail(String email) ;
}
