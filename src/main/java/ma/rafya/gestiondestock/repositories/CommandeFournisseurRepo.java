package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.entities.CommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeFournisseurRepo extends JpaRepository<CommandeFournisseur ,Long> {

    CommandeFournisseur findCommandeFournisseurByCode(String code) ;
}
