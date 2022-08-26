package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.ArticleDto;
import ma.rafya.gestiondestock.Dto.VenteDto;

import java.util.List;

public interface VenteService {


    VenteDto save(VenteDto venteDto) ;
    VenteDto findById(Long id ) ;
    VenteDto findByCodevente(String code) ;
    List<VenteDto> findAll() ;
    void delete(Long id)  ;
}
