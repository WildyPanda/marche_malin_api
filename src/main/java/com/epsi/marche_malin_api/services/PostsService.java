package com.epsi.marche_malin_api.services;

import com.epsi.marche_malin_api.dtos.GetPostDTO;
import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.PostCategory;
import com.epsi.marche_malin_api.entities.PostTag;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.repositories.ImageRepo;
import com.epsi.marche_malin_api.repositories.PostCategoryRepo;
import com.epsi.marche_malin_api.repositories.PostTagRepo;
import com.epsi.marche_malin_api.repositories.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostsService {
    @Autowired
    PostsRepo postsRepo;
    @Autowired
    PostCategoryRepo postCategoryRepo;
    @Autowired
    PostTagRepo postTagRepo;
    @Autowired
    ImageRepo imageRepo;

    public GetPostDTO GetPostById(Long id){
        Optional<Posts> optPost = postsRepo.findById(id);
        if(optPost.isPresent()){
            Posts post = optPost.get();
            List<Image> images = imageRepo.findAllByPost(post);
            List<PostCategory> categories = postCategoryRepo.findAllByIdPost(post);
            List<String> categoriesNames = new ArrayList<>();
            categories.forEach((elt) -> categoriesNames.add(elt.getId().getCategory().getNameCategory()));
            List<PostTag> tags = postTagRepo.findAllByIdPost(post);
            List<String> tagsNames = new ArrayList<>();
            tags.forEach((elt) -> tagsNames.add(elt.getId().getTag().getNameTag()));
            return new GetPostDTO(post.getIdPost(), post.getTitle(), post.getUser(), images, post.getMessage(), tagsNames, categoriesNames);
        }
        return null;
    }
}
