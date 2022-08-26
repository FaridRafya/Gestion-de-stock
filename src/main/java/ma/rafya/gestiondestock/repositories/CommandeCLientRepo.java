package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.CommandeClient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeCLientRepo extends JpaRepository<CommandeClient,Long> {

    CommandeClient findCommandeClientByCode(String code) ;
}
