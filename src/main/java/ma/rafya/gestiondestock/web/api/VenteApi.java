package ma.rafya.gestiondestock.web.api;

import io.swagger.annotations.Api;
import ma.rafya.gestiondestock.Dto.VenteDto;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

import static ma.rafya.gestiondestock.Utils.Constant.APP_ROOT;

@Api(APP_ROOT+"/ventes")
public interface VenteApi {

    @PostMapping(value =APP_ROOT+"/vente/create" ,consumes = MediaType.APPLICATION_JSON_VALUE,
            produces =MediaType.APPLICATION_JSON_VALUE )
    VenteDto save(VenteDto venteDto) ;
    @GetMapping(value =APP_ROOT+"/vente/{id}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    VenteDto findById(@PathVariable("id")  Long id) ;
    @GetMapping(value =APP_ROOT+"/vente/{code}'" , produces =MediaType.APPLICATION_JSON_VALUE )
    VenteDto findByCodevente(@PathVariable("code")  String code) ;
    @GetMapping(value =APP_ROOT+"/vente/all" , produces =MediaType.APPLICATION_JSON_VALUE )
    List<VenteDto> findAll() ;
    @DeleteMapping(value = APP_ROOT+"vente/deletevente/{id}")
    void delete(@PathVariable("id")  Long id)  ;

}
