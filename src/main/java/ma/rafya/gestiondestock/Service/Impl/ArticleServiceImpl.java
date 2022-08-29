package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.ArticleDto;
import ma.rafya.gestiondestock.Service.ArticleService;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.ArticleRepository;
import ma.rafya.gestiondestock.validator.ArticleValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;



@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository ;
    private ModelMapper modelMapper ;

    public ArticleServiceImpl(ArticleRepository articleRepository, ModelMapper modelMapper) {
        this.articleRepository = articleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ArticleDto save(ArticleDto articleDto) {
        List<String> errors= ArticleValidator.validate(articleDto);
        if(!errors.isEmpty()){

          throw new InvalidEntityException("article n'est pas valid" , ErrorCode.ARTIICLE_NOT_FOUND,errors);
        }
        /*Article article =modelMapper.map(articleDto,Article.class) ;
        Article article1= articleRepository.save(article) ;
      return modelMapper.map(article1,ArticleDto.class) ;*/


        ArticleDto dto = ArticleDto.fromEntity(articleRepository.save(ArticleDto.toEntity(articleDto)));
        return dto;
    }

    @Override
    public ArticleDto findById(Long id) {
        if (id==null){
            return  null ;  
        }
        Optional<Article> article=articleRepository.findById(id);


     //   ArticleDto articleDto=modelMapper.map(article,ArticleDto.class);
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException("aucun article avec id"+id));
    }

    @Override
    public ArticleDto findByCodeArticle(String code) {
        if(!StringUtils.hasLength(code))
        return null;
        Optional<Article> article =articleRepository.findByCodeArticle(code) ;
        return Optional.of(ArticleDto.fromEntity(article.get())).orElseThrow(()->
                new EntityNotFoundException("aucun article avec ce code"+code));

    }

    @Override
    public List<ArticleDto> findAll() {

        return  articleRepository.findAll().stream().map
                (ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
    articleRepository.deleteById(id);
    }
}
