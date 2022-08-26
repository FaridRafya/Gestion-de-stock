package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.UtilisateurDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/utilisateur")
public interface UtilisateurApi {

    @PostMapping(value =APP_ROOT+"/utilisateur/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    UtilisateurDto save (@RequestBody UtilisateurDto utilisateurDto) ;
    @GetMapping(value =APP_ROOT+"/utilisateur/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    UtilisateurDto findById(@PathVariable("id")  Long id );
    @GetMapping(value =APP_ROOT+"/utilisateur/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    UtilisateurDto findAll() ;
    @DeleteMapping(value = APP_ROOT+"utilisateur/deleteutilisateur/{id}")
    void delete(@PathVariable("id") Long id ) ;
}
