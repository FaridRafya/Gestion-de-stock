package ma.rafya.gestiondestock.web;

import io.swagger.annotations.Authorization;
import ma.rafya.gestiondestock.Dto.ClientDto;
import ma.rafya.gestiondestock.Service.ClientService;
import ma.rafya.gestiondestock.web.api.ClientApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

    private ClientService clientService ;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        return clientService.save(clientDto);
    }

    @Override
    public ClientDto findById(Long id) {
        return clientService.findById(id);
    }

    @Override
    public ClientDto findAll() {
        return clientService.findAll();
    }

    @Override
    public void delete(Long id) {

        clientService.delete(id);
    }
}
