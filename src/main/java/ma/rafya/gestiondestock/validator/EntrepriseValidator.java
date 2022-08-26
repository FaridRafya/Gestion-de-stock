package ma.rafya.gestiondestock.validator;

import ma.rafya.gestiondestock.Dto.ClientDto;
import ma.rafya.gestiondestock.Dto.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValidator {

    public static List<String> validate(EntrepriseDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("veullez rensigner le nom Emtreprise ");
            errors.add("veullez rensigner la description Emtreprise ");
            errors.add("veullez rensigner l'adresse Emtreprise ");
            errors.add("veullez rensigner l'adresse Emtreprise ");
            errors.add("veullez rensigner la photo  Emtreprise ");
            errors.add("veullez rensigner la email  Emtreprise ");
            errors.add("veullez rensigner la telephone  Emtreprise ");
            errors.add("veullez rensigner le siteWeb  Emtreprise ");


        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veullez rensigner le nom Emtreprise ");
        }
        if (!StringUtils.hasLength(dto.getDescription())) {
            errors.add("veullez rensigner la description Emtreprise ");
        }
        if (!StringUtils.hasLength(dto.getAdresse())) {
            errors.add("veullez rensigner l'adresse Emtreprise ");
        }
        if (!StringUtils.hasLength(dto.getPhoto())) {
            errors.add("veullez rensigner la photo  Emtreprise ");}
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("veullez rensigner la email  Emtreprise ");}
        if (!StringUtils.hasLength(dto.getTelephone())) {
            errors.add("veullez rensigner la telephone  Emtreprise ");}
        if (!StringUtils.hasLength(dto.getSiteWeb())) {
            errors.add("veullez rensigner le siteWeb  Emtreprise ");}
    return errors ;
    }
}