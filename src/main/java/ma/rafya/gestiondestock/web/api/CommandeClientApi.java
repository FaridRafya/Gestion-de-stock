package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.CommandeClientDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/commandeClient")
public interface CommandeClientApi {

    @PostMapping(value =APP_ROOT+"/commandeClient/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeClientDto save(CommandeClientDto commandeClientDto);

    @GetMapping(value =APP_ROOT+"/commandeClient/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeClientDto findById(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/commandeClient/{code}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeClientDto  findByCode(@PathVariable("code") String code);

    @GetMapping(value = APP_ROOT + "/commandeClient/all", produces = MediaType.APPLICATION_JSON_VALUE)
    default List<CommandeClientDto> findAll() {
        return null;
    }

    @DeleteMapping(value = APP_ROOT+"commandeCLient/deletecommandeclient/{id}")
    void  delete(@PathVariable("id") Long id);
}
