package ma.rafya.gestiondestock.Service.auth;

import ma.rafya.gestiondestock.entities.Utilisateur;
import ma.rafya.gestiondestock.repositories.UtilisateurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {
    @Autowired
    private UtilisateurRepo utilisateurRepo ;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur  utilisateur = utilisateurRepo.findByEmail(email).orElseThrow(()->
                new EntityNotFoundException("aucun utilisateur avec email"+email)) ;
        return new User(utilisateur.getEmail(),utilisateur.getMotDePass(), Collections.emptyList());
    }
}
