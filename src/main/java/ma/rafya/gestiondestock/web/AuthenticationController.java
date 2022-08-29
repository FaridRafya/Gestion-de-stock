package ma.rafya.gestiondestock.web;

import ma.rafya.gestiondestock.Dto.auth.AuthenticationRequest;
import ma.rafya.gestiondestock.Dto.auth.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager ;

    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request){

        //authenticationManager.authenticate(
              //  new UsernamePasswordAuthenticationToken(

              //  )
       // ) ;
    }
}
