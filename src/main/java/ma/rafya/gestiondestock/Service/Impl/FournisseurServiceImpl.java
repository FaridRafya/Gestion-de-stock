package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.FournisseurDto;
import ma.rafya.gestiondestock.Service.FournisseurService;
import ma.rafya.gestiondestock.entities.Fournisseur;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.FournisseurRepo;
import ma.rafya.gestiondestock.validator.FournisseurValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FournisseurServiceImpl implements FournisseurService {
    private FournisseurRepo fournisseurRepo;
    private ModelMapper modelMapper;

    public FournisseurServiceImpl(FournisseurRepo fournisseurRepo, ModelMapper modelMapper) {
        this.fournisseurRepo = fournisseurRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        List<String> errors = FournisseurValidator.validate(fournisseurDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Fournisseur n'est pas valid",
                    ErrorCode.FOURNISSEUR_NOT_FOUND, errors);
        }
        Fournisseur fournisseur = modelMapper.map(fournisseurDto, Fournisseur.class);
        Fournisseur fournisseur1 = fournisseurRepo.save(fournisseur);
        return modelMapper.map(fournisseur1, FournisseurDto.class);
    }

    @Override
    public FournisseurDto findById(Long id) {
        if (id == null)
            return null;
        Optional<Fournisseur> fournisseur = fournisseurRepo.findById(id);
        return Optional.of(modelMapper.map(fournisseur, FournisseurDto.class)).orElseThrow(()
                -> new EntityNotFoundException("Fournisseur non trouvé"));


    }

    @Override
    public FournisseurDto findAll() {
        return (FournisseurDto) fournisseurRepo.findAll().stream().map(e->modelMapper.map
                (e,FournisseurDto.class)).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        fournisseurRepo.deleteById(id);
    }
}