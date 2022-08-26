package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.CommandeFournisseurDto;
import ma.rafya.gestiondestock.Service.CommandeFournisseurService;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.CommandeFournisseur;
import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.exception.EntityNotFoundException;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.ArticleRepository;
import ma.rafya.gestiondestock.repositories.CommandeFournisseurRepo;
import ma.rafya.gestiondestock.repositories.FournisseurRepo;
import ma.rafya.gestiondestock.repositories.LigneCommandeFournisseurRepo;
import ma.rafya.gestiondestock.validator.CommandeFournisseurValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CommandeFournisseurServiceImpl implements CommandeFournisseurService {

    private ArticleRepository articleRepository ;
    private FournisseurRepo fournisseurRepo ;
    private ModelMapper modelMapper ;
    private CommandeFournisseurRepo commandeFournisseurRepo ;
    private LigneCommandeFournisseurRepo ligneCommandeFournisseurRepo ;

    public CommandeFournisseurServiceImpl(ArticleRepository articleRepository, FournisseurRepo fournisseurRepo, ModelMapper modelMapper, CommandeFournisseurRepo commandeFournisseurRepo, LigneCommandeFournisseurRepo ligneCommandeFournisseurRepo) {
        this.articleRepository = articleRepository;
        this.fournisseurRepo = fournisseurRepo;
        this.modelMapper = modelMapper;
        this.commandeFournisseurRepo = commandeFournisseurRepo;
        this.ligneCommandeFournisseurRepo = ligneCommandeFournisseurRepo;
    }


    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto dto) {
        List<String> errors = CommandeFournisseurValidator.validate(dto)  ;
        if(!errors.isEmpty()){
            throw new InvalidEntityException("commande Fournisseur est invalid ", ErrorCode.COMMANDE_CLIENT_NOT_FOUND,errors);
        }
        Optional<Fournisseur> fournisseur=fournisseurRepo.findById(dto.getFournisseur().getId()) ;
        if(!fournisseur.isPresent()){
            throw new EntityNotFoundException("fournisseur n'existe pas") ;
        }
        List<String> errorsArticle = new ArrayList<>() ;
        if(dto.getLigneCommandeFournisseurs()!=null) {
            dto.getLigneCommandeFournisseurs().forEach(ligne->{
                if(ligne.getArticle()!=null){
                    Optional<Article> article =articleRepository.findById(ligne.getArticle().getId()) ;
                    if(!article.isPresent()){
                        errorsArticle.add("article avec id"+ligne.getArticle().getId()+"n'existe pas") ;
                    }
                }
            });
        }
        if(!errorsArticle.isEmpty()){
            throw new InvalidEntityException("article est invalid",ErrorCode.ARTIICLE_NOT_FOUND,errorsArticle) ;
        }
        CommandeFournisseur commandeFournisseur=modelMapper.map(dto,CommandeFournisseur.class) ;
        CommandeFournisseur commandeFournisseur1=commandeFournisseurRepo.save(commandeFournisseur) ;
        return modelMapper.map(commandeFournisseur1, CommandeFournisseurDto.class);
    }

    @Override
    public CommandeFournisseurDto findById(Long id) {
        if (id ==null){
            return null ;
        }
        Optional<CommandeFournisseur> commandeFournisseur =commandeFournisseurRepo.findById(id) ;
        return Optional.of(modelMapper.map(commandeFournisseur,CommandeFournisseurDto.class)
        ).orElseThrow(()->  new EntityNotFoundException("Commande Fournisseur n'existe pas "));
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        if (code.isEmpty()){
            return null ;
        }
        CommandeFournisseur commandeFournisseur = commandeFournisseurRepo.findCommandeFournisseurByCode(code);
        return Optional.of(modelMapper.map(commandeFournisseur,CommandeFournisseurDto.class)
        ).orElseThrow(()->  new EntityNotFoundException("Commande Fournisseur n'existe pas "));
    }



    @Override
    public CommandeFournisseurDto findall() {
        return (CommandeFournisseurDto) commandeFournisseurRepo.findAll().stream().map(e->modelMapper.map
                (e,CommandeFournisseurDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
  commandeFournisseurRepo.deleteById(id);
    }
}
