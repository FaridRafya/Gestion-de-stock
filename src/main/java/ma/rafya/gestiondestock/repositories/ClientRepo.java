package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,Long> {
}
