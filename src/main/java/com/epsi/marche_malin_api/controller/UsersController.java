package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.dtos.UpdateEmailDTO;
import com.epsi.marche_malin_api.dtos.UpdatePhoneNbDTO;
import com.epsi.marche_malin_api.dtos.UpdateUsernameDTO;
import com.epsi.marche_malin_api.entities.Users;
import com.epsi.marche_malin_api.repositories.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UsersController {
    @Autowired
    private UsersRepo usersRepo;

    @GetMapping("/get")
    public Users getUser(){
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Optional<Users> usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        if(usersById.isEmpty()){
            String reg = Register();
            usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        }
        if(usersById.isPresent()){
            return usersById.get();
        }
        return null;
    }

    @PostMapping("/register")
    public String Register(){
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

    @PostMapping("/UpdateUsername")
    public String UpdateUsername(@RequestBody UpdateUsernameDTO dto){
        if(dto.getUsername() == null){
            return "The username must be present in the body";
        }
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Optional<Users> usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        if(usersById.isEmpty()){
            String reg = Register();
            if(!reg.equals("Correctly registered")){
                return "Error with the user, try using /user/register for more informations";
            }
            usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        }
        if(usersById.isPresent()){
            if(usersRepo.findByUsername(dto.getUsername()).isPresent()){
                return "Username is already used";
            }
            Users user = usersById.get();
            user.setUsername(dto.getUsername());
            usersRepo.save(user);
            return "Username correctly updated";
        }
        else{
            return "Error with the user, try using /user/register for more informations";
        }
    }

    @PostMapping("/UpdatePhoneNb")
    public String UpdatePhoneNb(@RequestBody UpdatePhoneNbDTO dto){
        if(dto.getPhoneNb() == null){
            return "The phoneNb must be present in the body";
        }
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Optional<Users> usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        if(usersById.isEmpty()){
            String reg = Register();
            if(!reg.equals("Correctly registered")){
                return "Error with the user, try using /user/register for more informations";
            }
            usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        }
        if(usersById.isPresent()){
            Users user = usersById.get();
            user.setPhoneNb(dto.getPhoneNb());
            usersRepo.save(user);
            return "Phone number correctly updated";
        }
        else{
            return "Error with the user, try using /user/register for more informations";
        }
    }

    @PostMapping("/UpdateEmail")
    public String UpdateEmail(@RequestBody UpdateEmailDTO dto){
        if(dto.getEmail() == null){
            return "The email must be present in the body";
        }
        JwtAuthenticationToken authentication = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Optional<Users> usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        if(usersById.isEmpty()){
            String reg = Register();
            if(!reg.equals("Correctly registered")){
                return "Error with the user, try using /user/register for more informations";
            }
            usersById = usersRepo.findById(authentication.getToken().getClaim("user_id"));
        }
        if(usersById.isPresent()){
            if(usersRepo.findByEmail(dto.getEmail()).isPresent()){
                return "Email is already used";
            }
            Users user = usersById.get();
            user.setEmail(dto.getEmail());
            usersRepo.save(user);
            return "Email correctly updated";
        }
        else{
            return "Error with the user, try using /user/register for more informations";
        }
    }
}
