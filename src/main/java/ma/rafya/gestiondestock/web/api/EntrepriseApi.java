package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.EntrepriseDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;
@Api(APP_ROOT+"/Entreprise")
public interface EntrepriseApi {

    @PostMapping(value =APP_ROOT+"/entreprise/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    EntrepriseDto save(EntrepriseDto entrepriseDto) ;

    @GetMapping(value =APP_ROOT+"/entreprise/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    EntrepriseDto findById(@PathVariable("id") Long id) ;

    @GetMapping(value =APP_ROOT+"/entreprise/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    EntrepriseDto findAll() ;

    @DeleteMapping(value = APP_ROOT+"entreprise/deleteEntreprise/{id}")
    void delete(@PathVariable("id") Long id) ;
}
