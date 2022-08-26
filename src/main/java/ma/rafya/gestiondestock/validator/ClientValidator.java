package ma.rafya.gestiondestock.validator;

import ma.rafya.gestiondestock.Dto.ClientDto;
import ma.rafya.gestiondestock.Dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {

    public static List<String> validate(ClientDto dto) {
        List<String> errors= new ArrayList<>() ;
        if(!StringUtils.hasLength(dto.getNom())){
            errors.add("veullez rensigner le nom Client ");}
        if(!StringUtils.hasLength(dto.getPrenom())){
            errors.add("veullez rensigner le prenom Client ");}
        if(!StringUtils.hasLength(dto.getPhoto())){
            errors.add("veullez rensigner la photo Client ");}
        if(!StringUtils.hasLength(dto.getAdresse())){
            errors.add("veullez rensigner l'adresse Client ");}
        if(!StringUtils.hasLength(dto.getTelephone())){
            errors.add("veullez rensigner le telephone Client ");}

return errors ;
}
}