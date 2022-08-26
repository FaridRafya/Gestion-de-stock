package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.UtilisateurDto;
import ma.rafya.gestiondestock.Service.UtilisateurService;
import ma.rafya.gestiondestock.entities.Utilisateur;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.UtilisateurRepo;
import ma.rafya.gestiondestock.validator.UtilisateurValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UtilisateurServiceimpl implements UtilisateurService {

    private UtilisateurRepo utilisateurRepo ;
    private ModelMapper  modelMapper ;

    public UtilisateurServiceimpl(UtilisateurRepo utilisateurRepo, ModelMapper modelMapper) {
        this.utilisateurRepo = utilisateurRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto utilisateurDto) {
        List<String> errors = UtilisateurValidator.validate(utilisateurDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException
                    ("Utilisateur n'est pas valid ", ErrorCode.UTILISATEUR_NOT_FOUND, errors);
        }
        Utilisateur utilisateur=modelMapper.map(utilisateurDto,Utilisateur.class) ;
        Utilisateur utilisateur1=utilisateurRepo.save(utilisateur) ;
        return modelMapper.map(utilisateur1,UtilisateurDto.class);
    }

    @Override
    public UtilisateurDto findById(Long id) {
        if(id ==null)
            return null ;
        Optional<Utilisateur> utilisateur=utilisateurRepo.findById(id) ;
        return Optional.of(modelMapper.map(utilisateur,UtilisateurDto.class)).
                orElseThrow(()-> new EntityNotFoundException("Utilisateur non trouveé"));
    }

    @Override
    public UtilisateurDto findAll() {
        return (UtilisateurDto) utilisateurRepo.findAll().stream().map
                (e->modelMapper.map(e,UtilisateurDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {

        utilisateurRepo.deleteById(id);
    }
}
