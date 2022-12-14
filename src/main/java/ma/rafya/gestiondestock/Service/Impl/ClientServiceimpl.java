package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.ClientDto;
import ma.rafya.gestiondestock.Service.ClientService;
import ma.rafya.gestiondestock.entities.Client;
import ma.rafya.gestiondestock.exception.EntityNotFoundException;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.ClientRepo;
import ma.rafya.gestiondestock.validator.ClientValidator;
import org.hibernate.action.internal.EntityActionVetoException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceimpl implements ClientService {

    private ClientRepo clientRepo;
    private ModelMapper modelMapper;

    public ClientServiceimpl(ClientRepo clientRepo, ModelMapper modelMapper) {
        this.clientRepo = clientRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("client est invalid", ErrorCode.CLIENT_NOT_FOUND, errors);
        }
        Client client = ClientDto.toEntity(clientDto) ;

        Client client1 = clientRepo.save(client);
        return ClientDto.fromEntity(client1) ;
    }

    @Override
    public ClientDto findById(Long id) {
        if (id == null)
            return null;
        Optional<Client> client = clientRepo.findById(id);
        return Optional.of(ClientDto.fromEntity(client.get())).orElseThrow(() ->
                new EntityNotFoundException("client n existe pas", ErrorCode.CLIENT_NOT_FOUND));
    }

    @Override
    public List<ClientDto> findAll() {
        return  clientRepo.findAll().stream().map
                (ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
         clientRepo.deleteById(id);
    }
}
