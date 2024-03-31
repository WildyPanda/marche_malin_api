package com.epsi.marche_malin_api.services;

import com.epsi.marche_malin_api.entities.PostCategory;
import com.epsi.marche_malin_api.entities.PostTag;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.repositories.PostCategoryRepo;
import com.epsi.marche_malin_api.repositories.PostTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostCategoryService {
    @Autowired
    PostCategoryRepo postCategoryRepo;

    public void DeleteAllByPost(Posts post){
        List<PostCategory> postCategories = postCategoryRepo.findAllByIdPost(post);
        for(PostCategory postCategory : postCategories){
            postCategoryRepo.delete(postCategory);
        }
    }
}
