package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.entities.mvtstk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Mvtstkrepo extends JpaRepository <mvtstk,Long>{
}
