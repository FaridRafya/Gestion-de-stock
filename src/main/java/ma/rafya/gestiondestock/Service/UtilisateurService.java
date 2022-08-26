package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.UtilisateurDto;

public interface UtilisateurService {

    UtilisateurDto save (UtilisateurDto utilisateurDto) ;
    UtilisateurDto findById( Long id );
    UtilisateurDto findAll() ;
    void delete(Long id ) ;
}
