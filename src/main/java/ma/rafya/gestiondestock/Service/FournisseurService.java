package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.FournisseurDto;

public interface FournisseurService {

    FournisseurDto save (FournisseurDto fournisseurDto) ;
    FournisseurDto findById(Long id );
    FournisseurDto findAll();
    void delete(Long id) ;
}
