package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.CommandeFournisseurDto;
import ma.rafya.gestiondestock.Service.CommandeFournisseurService;
import ma.rafya.gestiondestock.web.api.CommandeFournisseurApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandeFournisseurController implements CommandeFournisseurApi {

    private CommandeFournisseurService commandeFournisseurService ;

    @Autowired
    public CommandeFournisseurController(CommandeFournisseurService commandeFournisseurService) {
        this.commandeFournisseurService = commandeFournisseurService;
    }

    @Override
    public CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto) {
        return commandeFournisseurService.save(commandeFournisseurDto);
    }

    @Override
    public CommandeFournisseurDto findById(Long id) {
        return commandeFournisseurService.findById(id);
    }

    @Override
    public CommandeFournisseurDto findByCode(String code) {
        return commandeFournisseurService.findByCode(code);
    }

    @Override
    public CommandeFournisseurDto findall() {
        return commandeFournisseurService.findall();
    }

    @Override
    public void delete(Long id) {
        commandeFournisseurService.delete(id);
    }
}
