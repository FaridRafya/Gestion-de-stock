package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.FournisseurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/Fournisseur")
public interface FournisseurApi {

    @PostMapping(value =APP_ROOT+"/Fournisseur/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    FournisseurDto save (FournisseurDto fournisseurDto) ;

    @GetMapping(value =APP_ROOT+"/Fournisseur/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    FournisseurDto findById(@PathVariable("id") Long id );

    @GetMapping(value =APP_ROOT+"/Fournisseur/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    FournisseurDto findAll();

    @DeleteMapping(value = APP_ROOT+"entreprise/deleteEntreprise/{id}")
    void delete(@PathVariable("id") Long id) ;
}
