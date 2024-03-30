package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.dtos.GetPostDTO;
import com.epsi.marche_malin_api.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostsController {
    @Autowired
    PostsService service;

    @GetMapping("/public/get/{id}")
    public GetPostDTO GetPost(@PathVariable Long id){
        return service.GetPostById(id);
    }
}
