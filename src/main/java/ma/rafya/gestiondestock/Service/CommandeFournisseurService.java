package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.CommandeClientDto;
import ma.rafya.gestiondestock.Dto.CommandeFournisseurDto;

public interface CommandeFournisseurService {

    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    CommandeFournisseurDto findById(Long id);

    CommandeFournisseurDto findByCode(String code);

    CommandeFournisseurDto findall();

    void delete(Long id);
}


