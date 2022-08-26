package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.ClientDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/client")
public interface ClientApi {

    @PostMapping(value =APP_ROOT+"/client/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    ClientDto save(@RequestBody ClientDto clientDto) ;

    @GetMapping(value =APP_ROOT+"/client/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    ClientDto findById(@PathVariable("id") Long id) ;

    @GetMapping(value =APP_ROOT+"/client/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    ClientDto findAll();

    @DeleteMapping(value = APP_ROOT+"client/deleteClient/{id}")
    void delete(@PathVariable("id") Long id) ;
}
