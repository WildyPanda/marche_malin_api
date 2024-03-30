package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.dtos.CreatePostDTO;
import com.epsi.marche_malin_api.dtos.GetPostDTO;
import com.epsi.marche_malin_api.entities.*;
import com.epsi.marche_malin_api.repositories.*;
import com.epsi.marche_malin_api.services.ImageService;
import com.epsi.marche_malin_api.services.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostsController {
    @Autowired
    PostsService service;
    @Autowired
    PostsRepo repo;
    @Autowired
    TagsRepo tagsRepo;
    @Autowired
    PostTagRepo postTagRepo;
    @Autowired
    PostCategoryRepo postCategoryRepo;
    @Autowired
    ImageRepo imageRepo;

    @GetMapping("/public/get/{id}")
    public GetPostDTO GetPost(@PathVariable Long id){
        return service.GetPostById(id);
    }

    @PostMapping("/add")
    public String AddPost(@RequestBody CreatePostDTO dto){
        for(String tags : dto.getTags()){
            Optional<Tags> tag = tagsRepo.findById(tags);
            if(tag.isEmpty()){
                tagsRepo.save(new Tags(tags));
            }
        }
        Posts post = new Posts(null, dto.getUser(), dto.getTitle(), dto.getMessage());
        repo.save(post);
        for(String tags : dto.getTags()){
            postTagRepo.save(new PostTag(new PostTag.PostTagId(post, new Tags(tags))));
        }
        for(String categories : dto.getCategories()){
            postCategoryRepo.save(new PostCategory(new PostCategory.PostCategoryId(post, new Categories(categories))));
        }
        for(byte[] image : dto.getImages()){
            imageRepo.save(new Image(null, image, post));
        }
        return "ok";
    }
}
