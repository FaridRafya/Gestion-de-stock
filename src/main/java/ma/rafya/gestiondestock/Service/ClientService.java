package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.ClientDto;

import java.util.List;

public interface ClientService {
    ClientDto save(ClientDto clientDto) ;
    ClientDto findById(Long id) ;
   List<ClientDto>  findAll();
    void delete(Long id) ;
}
