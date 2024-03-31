package com.epsi.marche_malin_api.services;

import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.PostTag;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.repositories.PostTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostTagService {
    @Autowired
    PostTagRepo postTagRepo;

    public void DeleteAllByPost(Posts post){
        List<PostTag> postTags = postTagRepo.findAllByIdPost(post);
        for(PostTag postTag : postTags){
            postTagRepo.delete(postTag);
        }
    }
}
