package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository <Category,Long> {

    Category findByCodeCategory(String code );
}
