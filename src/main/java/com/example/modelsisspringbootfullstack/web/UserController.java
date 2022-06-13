package com.example.modelsisspringbootfullstack.web;
import com.example.modelsisspringbootfullstack.dto.AppUserDto;
import com.example.modelsisspringbootfullstack.entities.AppUser;
import com.example.modelsisspringbootfullstack.entities.Response;
import com.example.modelsisspringbootfullstack.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private AccountService accountService;
    @PostMapping("/register")
    public Response register(@RequestBody AppUserDto appUserDto){
        Response response = new Response();
        AppUser estla = accountService.loadUserByUsername(appUserDto.getUsername());
        System.out.println("**********"+estla);
        if (!appUserDto.getPassword().equals(appUserDto.getConfirmedPassword())) {
            response.setStatut(403);
            response.setDescription("Les mots de passe ne sont pas identique!!");
        } else if (estla==null) {
            try {
                accountService.saveUser(appUserDto);
                response.setStatut(200);
                response.setDescription("Inscription réussie");
            } catch (Exception ex) {
                response.setStatut(500);
                response.setDescription("Inscription non réussie. Vérifier les informations saisies!");
            }
        } else {
            response.setStatut(500);
            response.setDescription("Le nom d'utilisateur est déjà attribué.");
        }
        return response;
    }
}
