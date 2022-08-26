package ma.rafya.gestiondestock.validator;

import ma.rafya.gestiondestock.Dto.EntrepriseDto;
import ma.rafya.gestiondestock.Dto.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto dto) {
        List<String> errors = new ArrayList<>();
        if(dto== null){
            errors.add("veullez rensigner le nom Fournisseur ");
            errors.add("veullez rensigner le prenom Fournisseur ");
            errors.add("veullez rensigner l'adresse Fournisseur ");
            errors.add("veullez rensigner le photo Fournisseur ");
            errors.add("veullez rensigner le photo Fournisseur ");
            errors.add("veullez rensigner email Fournisseur ");
            errors.add("veullez rensigner telephone Fournisseur ");

        }
        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("veullez rensigner le nom Fournisseur ");

        }
        if (!StringUtils.hasLength(dto.getPrenom())) {
            errors.add("veullez rensigner le prenom Fournisseur ");

        }
        if (!StringUtils.hasLength(dto.getAdresse())) {
            errors.add("veullez rensigner l'adresse Fournisseur ");

        }
        if (!StringUtils.hasLength(dto.getPhoto())) {
            errors.add("veullez rensigner le photo Fournisseur ");

        }
        if (!StringUtils.hasLength(dto.getEmail())) {
            errors.add("veullez rensigner email Fournisseur ");

        }if (!StringUtils.hasLength(dto.getTelephone())) {
            errors.add("veullez rensigner telephone Fournisseur ");

        }

 return  errors ;
    }
}