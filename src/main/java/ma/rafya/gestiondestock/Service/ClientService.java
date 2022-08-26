package ma.rafya.gestiondestock.Service;

import ma.rafya.gestiondestock.Dto.ClientDto;

public interface ClientService {
    ClientDto save(ClientDto clientDto) ;
    ClientDto findById(Long id) ;
    ClientDto findAll();
    void delete(Long id) ;
}
