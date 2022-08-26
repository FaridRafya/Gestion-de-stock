package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.VenteDto;
import ma.rafya.gestiondestock.Service.VenteService;
import ma.rafya.gestiondestock.web.api.VenteApi;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VenteController implements VenteApi {

    private VenteService venteService ;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @Override
    public VenteDto save(VenteDto venteDto) {
        return venteService.save(venteDto);
    }

    @Override
    public VenteDto findById(Long id) {
        return venteService.findById(id);
    }

    @Override
    public VenteDto findByCodevente(String code) {
        return venteService.findByCodevente(code);
    }

    @Override
    public List<VenteDto> findAll() {
        return venteService.findAll();
    }

    @Override
    public void delete(Long id) {
        venteService.delete(id);
    }
}
