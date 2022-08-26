package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.FournisseurDto;
import ma.rafya.gestiondestock.Service.FournisseurService;
import ma.rafya.gestiondestock.web.api.FournisseurApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FournisseurController implements FournisseurApi {

    private FournisseurService fournisseurService ;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @Override
    public FournisseurDto save(FournisseurDto fournisseurDto) {
        return fournisseurService.save(fournisseurDto);
    }

    @Override
    public FournisseurDto findById(Long id) {
        return fournisseurService.findById(id);
    }

    @Override
    public FournisseurDto findAll() {
        return fournisseurService.findAll();
    }

    @Override
    public void delete(Long id) {
        fournisseurService.delete(id);
    }
}
