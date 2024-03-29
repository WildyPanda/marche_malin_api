package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.entities.Users;
import com.epsi.marche_malin_api.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UsersController {
    @Autowired
    private UsersRepo usersRepo;

    @PostMapping("/register")
    public String register(){
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Optional<Users> usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        Optional<Users> usersByEmail = usersRepo.findByEmail(authentication.getToken().getClaim("email"));
        if(usersById.isEmpty()){
            if(usersByEmail.isPresent()){
                return "The email is already used";
            }
            Users user = new Users(authentication.getToken().getClaim("user_id"), authentication.getToken().getClaim("email"), null, null);
            usersRepo.save(user);
            return "Correctly registered";
        }
        return "The user exist";
    }
}
