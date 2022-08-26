package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.CategoryDto;
import ma.rafya.gestiondestock.Dto.CommandeClientDto;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto commandeClientDto);

    CommandeClientDto findById(Long id);

    CommandeClientDto findByCode(String code);

    CommandeClientDto findAll();

    void delete(Long id);
}
