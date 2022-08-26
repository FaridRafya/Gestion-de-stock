package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.ArticleDto;

import java.util.List;

public interface ArticleService {

    ArticleDto save(ArticleDto articleDto) ;
    ArticleDto findById(Long id ) ;
    ArticleDto findByCodeArticle(String code) ;
    List<ArticleDto> findAll() ;
    void delete(Long id)  ;
}
