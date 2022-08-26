package ma.rafya.gestiondestock.repositories;

import ma.rafya.gestiondestock.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ArticleRepository extends JpaRepository<Article, Long> {


    Optional<Article>  findByCodeArticle(String code);
}
