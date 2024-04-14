package com.epsi.marche_malin_api.controller;

import com.epsi.marche_malin_api.dtos.*;
import com.epsi.marche_malin_api.entities.*;
import com.epsi.marche_malin_api.repositories.*;
import com.epsi.marche_malin_api.services.ImageService;
import com.epsi.marche_malin_api.services.PostCategoryService;
import com.epsi.marche_malin_api.services.PostTagService;
import com.epsi.marche_malin_api.services.PostsService;
import com.google.firebase.database.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
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
    @Autowired
    ImageService imageService;
    @Autowired
    PostTagService postTagService;
    @Autowired
    PostCategoryService postCategoryService;

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

    @PostMapping("/modify")
    public String AddPost(@RequestBody ModifyPostDTO dto){
        for(String tags : dto.getTags()){
            Optional<Tags> tag = tagsRepo.findById(tags);
            if(tag.isEmpty()){
                tagsRepo.save(new Tags(tags));
            }
        }
        Posts post = new Posts(dto.getId_post(), dto.getUser(), dto.getTitle(), dto.getMessage());
        repo.save(post);
        postTagService.DeleteAllByPost(post);
        for(String tags : dto.getTags()){
            postTagRepo.save(new PostTag(new PostTag.PostTagId(post, new Tags(tags))));
        }
        postCategoryService.DeleteAllByPost(post);
        for(String categories : dto.getCategories()){
            postCategoryRepo.save(new PostCategory(new PostCategory.PostCategoryId(post, new Categories(categories))));
        }
        imageService.DeleteAllByPost(post);
        for(byte[] image : dto.getImages()){
            imageRepo.save(new Image(null, image, post));
        }
        return "ok";
    }

    @PostMapping("/public/SearchPosts")
    public List<BasicPostDTO> SearchPosts(@RequestBody @NotNull SearchPostsDTO dto){
        List<Posts> titlePosts = null;
        if(dto.getTitle() != null && !dto.getTitle().isEmpty()){
            titlePosts = getByName(dto.getTitle());
        }
        List<Posts> tagPosts = null;
        if(dto.getTags() != null && !dto.getTags().isEmpty()){
            tagPosts = getByTags(dto.getTags());
        }
        List<Posts> catPosts = null;
        if(dto.getCategories() != null && !dto.getCategories().isEmpty()){
            catPosts = getByCategories(dto.getCategories());
        }
        List<Posts> result = new ArrayList<>();
        boolean A = titlePosts == null;
        boolean B = tagPosts == null;
        boolean C = catPosts == null;
        System.out.println(A + " : " + B + " : " + C);
        if(A && B && C)
            return PostsListToBasicPostList(service.findAll());
        else if(!A && B && C)
            return PostsListToBasicPostList(titlePosts);
        else if(A && !B && C)
            return PostsListToBasicPostList(tagPosts);
        else if(A && B && !C)
            return PostsListToBasicPostList(catPosts);
        else if(!A && !B && C)
            return PostsListToBasicPostList(IntersectList(titlePosts, tagPosts));
        else if(!A && B && !C)
            return PostsListToBasicPostList(IntersectList(titlePosts, catPosts));
        else if(A && !B && !C)
            return PostsListToBasicPostList(IntersectList(tagPosts, catPosts));
        else
        return PostsListToBasicPostList(IntersectList(titlePosts, tagPosts, catPosts));
    }

    protected <T> List<T> IntersectList(List<T> list1, List<T> list2){
        List<T> res = new ArrayList<>();
        for(T elt : list1){
            if(list2.contains(elt)){
                res.add(elt);
            }
        }
        return res;
    }

    protected <T> List<T> IntersectList(List<T> list1, List<T> list2, List<T> list3){
        List<T> res = new ArrayList<>();
        for(T elt : list1){
            if(list2.contains(elt) && list3.contains(elt)){
                res.add(elt);
            }
        }
        return res;
    }

    protected List<BasicPostDTO> PostsListToBasicPostList(List<Posts> posts){
        List<BasicPostDTO> basicPosts = new ArrayList<>();
        for(Posts post : posts){
            basicPosts.add(new BasicPostDTO(post, imageService.GetFirstOfPost(post)));
        }
        return basicPosts;
    }

    @PostMapping("/getByName")
    public List<Posts> getByName(@RequestBody String title){
        return service.findByName(title);
    }

    @GetMapping("/getByTag/{tag}")
    public List<Tags> getByTags(@PathVariable @NotNull String tag){
        return postTagService.GetByTag(tag);
    }

    @PostMapping("/getByTag")
    public List<Posts> getByTags(@RequestBody @NotNull List<String> tag){
        return postTagService.findByTag(tag);
    }

    @PostMapping("/getByCategories")
    public List<Posts> getByCategories(@RequestBody @NotNull List<String> categories){
        return postCategoryService.findByCategories(categories);
    }
}
