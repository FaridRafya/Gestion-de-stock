package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.EntrepriseDto;

public interface EntrepriseService {

    EntrepriseDto save(EntrepriseDto entrepriseDto) ;
    EntrepriseDto findById(Long id) ;
    EntrepriseDto findAll() ;
    void delete(Long id) ;
}
