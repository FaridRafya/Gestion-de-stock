package ma.rafya.gestiondestock.validator;

import ma.rafya.gestiondestock.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {


    public static List<String> validate(UtilisateurDto utilisateurDto) {
        List<String> errors = new ArrayList<>();
        if (utilisateurDto == null) {

            errors.add("veullez rensigner le nom utitisateur ");
            errors.add("veullez rensigner le prenom utitisateur ");
            errors.add("veullez rensigner le email utitisateur ");
            errors.add("veullez rensigner le Mot De Passs utitisateur ");
            errors.add("veullez rensigner le adresse Utilisateur ");

        }
        if (!StringUtils.hasLength(utilisateurDto.getNom())) {
            errors.add("veullez rensigner le nom utitisateur ");
        }
        if (!StringUtils.hasLength(utilisateurDto.getPrenom())) {
            errors.add("veullez rensigner le prenom utitisateur ");
        }
        if (!StringUtils.hasLength(utilisateurDto.getEmail())) {
            errors.add("veullez rensigner le email utitisateur ");
        }
        if (!StringUtils.hasLength(utilisateurDto.getMotDePass())) {
            errors.add("veullez rensigner le Mot De Passs utitisateur ");
        }
        if (!StringUtils.hasLength(utilisateurDto.getAdresse())) {
            errors.add("veullez rensigner le adresse Utilisateur ");
        }
        return errors;
    }
}
