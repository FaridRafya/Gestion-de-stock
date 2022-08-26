package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.CommandeClientDto;
import ma.rafya.gestiondestock.Service.CommandeClientService;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.Client;
import ma.rafya.gestiondestock.entities.CommandeClient;
import ma.rafya.gestiondestock.exception.EntityNotFoundException;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.ArticleRepository;
import ma.rafya.gestiondestock.repositories.ClientRepo;
import ma.rafya.gestiondestock.repositories.CommandeCLientRepo;
import ma.rafya.gestiondestock.repositories.LigneCommandeClientRepo;
import ma.rafya.gestiondestock.validator.CommandeClientValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandeClientServiceImpl implements CommandeClientService {
    private ArticleRepository articleRepo ;
    private CommandeCLientRepo commandeCLientRepo ;
    private ClientRepo  clientRepo ;
    private LigneCommandeClientRepo ligneCommandeClientRepo ;
    private ModelMapper modelMapper ;

    @Autowired
    public CommandeClientServiceImpl(ArticleRepository articleRepo,  CommandeCLientRepo commandeCLientRepo ,ClientRepo clientRepo, LigneCommandeClientRepo ligneCommandeClientRepo, ModelMapper modelMapper) {
        this.articleRepo = articleRepo;
        this.clientRepo = clientRepo;
        this.ligneCommandeClientRepo = ligneCommandeClientRepo;
        this.modelMapper = modelMapper;
        this.commandeCLientRepo=commandeCLientRepo;
    }

    @Override
    public CommandeClientDto save(CommandeClientDto dto) {
        List<String> errors = CommandeClientValidator.validate(dto);
        if(!errors.isEmpty()){
            throw new InvalidEntityException("commande client est invalid ", ErrorCode.COMMANDE_CLIENT_NOT_FOUND,errors);
        }
        Optional<Client> client=clientRepo.findById(dto.getClient().getId()) ;
        if(!client.isPresent()){
            throw new EntityNotFoundException("client n'existe pas") ;
        }
        List<String> errorsArticle =new ArrayList<>() ;
        if(dto.getLigneCommandeClients()!=null){
            dto.getLigneCommandeClients().forEach(ligne->{
                if(ligne.getArticle()!=null){
                    Optional<Article> article =articleRepo.findById(ligne.getArticle().getId()) ;
                    if(!article.isPresent()){
                      errorsArticle.add("article avec id"+ligne.getArticle().getId()+"n'existe pas") ;
                    }
                }
            });
        }
        if(!errorsArticle.isEmpty()){
            throw new InvalidEntityException("article est invalid",ErrorCode.ARTIICLE_NOT_FOUND,errorsArticle) ;
        }
        CommandeClient commandeClient=modelMapper.map(dto,CommandeClient.class) ;
        CommandeClient commandeClient1=commandeCLientRepo.save(commandeClient) ;
        return modelMapper.map(commandeClient1,CommandeClientDto.class);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        if (id==null)
            return null ;
        Optional<CommandeClient> commandeClient=commandeCLientRepo.findById(id) ;

        return Optional.of(modelMapper.map(commandeClient,CommandeClientDto.class)).orElseThrow(
                ()-> new EntityNotFoundException("commande client n'existe pas" )
        );
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        if(code.isEmpty()){
            return null ;
        }
        CommandeClient  commandeClient =commandeCLientRepo.findCommandeClientByCode(code) ;
        return Optional.of(modelMapper.map(commandeClient,CommandeClientDto.class)).orElseThrow(
                ()-> new EntityNotFoundException("commande client n'existe pas" )
        );
    }

    @Override
    public CommandeClientDto findAll() {
        return (CommandeClientDto) commandeCLientRepo.findAll().stream()
                .map(e->modelMapper.map(e,CommandeClientDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        commandeCLientRepo.deleteById(id);

    }
}
