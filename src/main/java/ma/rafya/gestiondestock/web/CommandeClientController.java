package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.CommandeClientDto;
import ma.rafya.gestiondestock.Service.CommandeClientService;
import ma.rafya.gestiondestock.web.api.CommandeClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class CommandeClientController implements CommandeClientApi {

    private CommandeClientService commandeClientService;

    @Autowired
    public CommandeClientController(CommandeClientService commandeClientService) {
        this.commandeClientService = commandeClientService;
    }


    @Override
    public CommandeClientDto save(CommandeClientDto commandeClientDto) {
        return commandeClientService.save( commandeClientDto);
    }

    @Override
    public CommandeClientDto findById(Long id) {
        return commandeClientService.findById(id);
    }

    @Override
    public CommandeClientDto findByCode(String code) {
        return commandeClientService.findByCode(code);
    }

    @Override
    public CommandeClientDto findAll() {
        return commandeClientService.findAll();
    }

    @Override
    public void delete(Long id) {

        commandeClientService.delete(id);
    }
}