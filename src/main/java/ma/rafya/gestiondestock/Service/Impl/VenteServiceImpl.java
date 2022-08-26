package ma.rafya.gestiondestock.Service.Impl;

import ma.rafya.gestiondestock.Dto.VenteDto;
import ma.rafya.gestiondestock.Service.VenteService;
import ma.rafya.gestiondestock.entities.Article;
import ma.rafya.gestiondestock.entities.Vente;
import ma.rafya.gestiondestock.exception.EntityNotFoundException;
import ma.rafya.gestiondestock.exception.ErrorCode;
import ma.rafya.gestiondestock.exception.InvalidEntityException;
import ma.rafya.gestiondestock.repositories.ArticleRepository;
import ma.rafya.gestiondestock.repositories.LigneVenteRepo;
import ma.rafya.gestiondestock.repositories.VenteRepo;
import ma.rafya.gestiondestock.validator.VenteValidator;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VenteServiceImpl implements VenteService {

    private VenteRepo venteRepo;
    private ModelMapper modelMapper;
    private ArticleRepository articleRepository;
    private LigneVenteRepo ligneVenteRepo;

    public VenteServiceImpl(VenteRepo venteRepo, ModelMapper modelMapper, ArticleRepository articleRepository, LigneVenteRepo ligneVenteRepo) {
        this.venteRepo = venteRepo;
        this.modelMapper = modelMapper;
        this.articleRepository = articleRepository;
        this.ligneVenteRepo = ligneVenteRepo;
    }

    @Override
    public VenteDto save(VenteDto dto) {
        List<String> errors = VenteValidator.validate(dto);
        if (!errors.isEmpty()) {
            throw new InvalidEntityException("Vente n'exite pas", ErrorCode.VENTE_NOT_FOUND, errors);
        }
        List<String> errorsArticle = new ArrayList<>();
        if (dto.getLigneVenteDtos() != null) {
            dto.getLigneVenteDtos().forEach(ligne -> {
                Optional<Article> article = articleRepository.findById(ligne.getArticleDto().getId());
                if (!article.isPresent()) {
                    errorsArticle.add("l'article avec id" + ligne.getArticleDto().getId() + "ne trouve pas dans ddb");
                }
            });
        }
        if (!errorsArticle.isEmpty()) {
            throw new InvalidEntityException("", ErrorCode.ARTIICLE_NOT_FOUND, errorsArticle);
        }
        Vente vente = modelMapper.map(dto, Vente.class);
        Vente vente1 = venteRepo.save(vente);

        return modelMapper.map(vente1, VenteDto.class);
    }

    @Override
    public VenteDto findById(Long id) {
        if (id == null) {
            return null;
        }
        Optional<Vente> vente = venteRepo.findById(id);
        return Optional.of(modelMapper.map(vente, VenteDto.class)).orElseThrow(
                () -> new EntityNotFoundException("Vente n'existe pas dans ddb")
        );
    }

    @Override
    public VenteDto findByCodevente(String code) {
        if (code == null) {
            return null;
        }
        Vente vente = venteRepo.findByCode(code);
        return Optional.of(modelMapper.map(vente, VenteDto.class)).orElseThrow(
                () -> new EntityNotFoundException("Vente n'existe pas dans ddb")
        );
    }

    @Override
    public List<VenteDto> findAll() {
        return venteRepo.findAll().stream().map(e->modelMapper.map(e,VenteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
       venteRepo.deleteById(id);
    }
}
