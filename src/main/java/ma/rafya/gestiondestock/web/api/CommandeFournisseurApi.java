package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.CommandeFournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;
@Api(APP_ROOT+"/commandeFournisseur")
public interface CommandeFournisseurApi {

    @PostMapping(value =APP_ROOT+"/commandeFournisseur/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeFournisseurDto save(CommandeFournisseurDto commandeFournisseurDto);

    @GetMapping(value =APP_ROOT+"/commandeFournisseur/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeFournisseurDto findById(@PathVariable("id") Long id);

    @GetMapping(value =APP_ROOT+"/commandeFournisseur/{code}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeFournisseurDto findByCode(@PathVariable("code") String code);

    @GetMapping(value =APP_ROOT+"/commandeFournisseur/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    CommandeFournisseurDto findall();
    @DeleteMapping(value = APP_ROOT+"commandeFournisseur/deletecommandeFournisseur/{id}")
    void delete(@PathVariable("id") Long id);
}
