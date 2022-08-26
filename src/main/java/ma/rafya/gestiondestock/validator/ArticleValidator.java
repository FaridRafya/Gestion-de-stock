package ma.rafya.gestiondestock.validator;

import ma.rafya.gestiondestock.Dto.ArticleDto;
import ma.rafya.gestiondestock.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticleDto articleDto) {
        List<String> errors = new ArrayList<>();
        if (articleDto == null) {
            errors.add("veullez rensigner le code  article ");
            errors.add("veullez rensigner  la description  article ");
            errors.add("veullez rensigner le prix unitaire  article ");
            errors.add("veullez rensigner le TAUX Tva  article ");
            errors.add("veullez rensigner le prix unitaire Ttc   article ");
            errors.add("veullez rensigner la category  article ");
        }
        if (!StringUtils.hasLength(articleDto.getCodeArticle())) {
            errors.add("veullez rensigner le code  article ");
        }
        if (!StringUtils.hasLength(articleDto.getDescription())) {
            errors.add("veullez rensigner  la description  article ");
        }
        if (articleDto.getPrixUnitaireht() == null) {
            errors.add("veullez rensigner le prix unitaire  article ");
        }
        if (articleDto.getTauxTva() == null) {
            errors.add("veullez rensigner le TAUX Tva  article ");
        }
        if (articleDto.getPrixUnitaireTtc() == null) {
            errors.add("veullez rensigner le prix unitaire Ttc   article ");
        }
        if (articleDto.getCategoryDto() == null) {
            errors.add("veullez rensigner la category  article ");
        }

        return errors;
    }
}
