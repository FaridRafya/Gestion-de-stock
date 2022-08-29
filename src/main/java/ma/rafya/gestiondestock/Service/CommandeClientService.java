package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.CategoryDto;
import ma.rafya.gestiondestock.Dto.CommandeClientDto;

import java.util.List;

public interface CommandeClientService {

    CommandeClientDto save(CommandeClientDto commandeClientDto);

    CommandeClientDto findById(Long id);

    CommandeClientDto findByCode(String code);

    List<CommandeClientDto>  findAll();

    void delete(Long id);
}
