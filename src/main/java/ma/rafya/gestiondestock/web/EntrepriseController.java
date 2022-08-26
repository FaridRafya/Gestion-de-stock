package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.EntrepriseDto;
import ma.rafya.gestiondestock.Service.EntrepriseService;
import ma.rafya.gestiondestock.web.api.EntrepriseApi;
import org.springframework.beans.factory.annotation.Autowired;

public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService ;

    @Autowired
    public EntrepriseController(EntrepriseService entrepriseService) {
        this.entrepriseService = entrepriseService;
    }

    @Override
    public EntrepriseDto save(EntrepriseDto entrepriseDto) {
        return entrepriseService.save(entrepriseDto);
    }

    @Override
    public EntrepriseDto findById(Long id) {
        return entrepriseService
                .findById(id);
    }

    @Override
    public EntrepriseDto findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Long id) {
        entrepriseService.delete(id);
    }
}
