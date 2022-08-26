package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.entities.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepo  extends JpaRepository<Utilisateur,Long> {
}
