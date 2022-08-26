package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.EntrepriseDto;
import ma.rafya.gestiondestock.Service.EntrepriseService;
import ma.rafya.gestiondestock.entities.Entreprise;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.EntrepriseRepo;
import ma.rafya.gestiondestock.validator.EntrepriseValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EntrepriseServiceImpl implements EntrepriseService {

    private EntrepriseRepo entrepriseRepo;
    private ModelMapper modelMapper ;

    public EntrepriseServiceImpl(EntrepriseRepo entrepriseRepo, ModelMapper modelMapper) {
        this.entrepriseRepo = entrepriseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        List<String> errors= EntrepriseValidator.validate(entrepriseDto) ;
        if(!errors.isEmpty()){
            throw  new InvalidEntityException("entreprise est invalid", ErrorCode.ENTREPRISE_NOT_FOUND,errors);
        }
        Entreprise entreprise= modelMapper.map(entrepriseDto,Entreprise.class) ;
        Entreprise entreprise1= entrepriseRepo.save(entreprise) ;
        return modelMapper.map(entreprise1,EntrepriseDto.class);
    }

    @Override
    public EntrepriseDto findById(Long id) {
        if(id == null)
            return null ;
        Optional<Entreprise> entreprise = entrepriseRepo.findById(id) ;
        return Optional.of(modelMapper.map(entreprise,EntrepriseDto.class)).orElseThrow(()->
                new EntityNotFoundException("entreprise n'existe pas"));
    }

    @Override
    public EntrepriseDto findAll() {

        return (EntrepriseDto) entrepriseRepo.findAll().stream().map
                (e->modelMapper.map(e,EntrepriseDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        entrepriseRepo.deleteById(id);
    }
}
