package com.epsi.marche_malin_api.services;

import com.epsi.marche_malin_api.entities.*;
import com.epsi.marche_malin_api.repositories.PostCategoryRepo;
import com.epsi.marche_malin_api.repositories.PostTagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public List<Posts> findByCategories(List<String> categories) {

        List<Posts> postsWithAllCategories = new ArrayList<>();
        List<PostCategory> listEntity = postCategoryRepo.findAll();
        for (PostCategory postCategory : listEntity) {

            int nbCat = categories.size();
            int corresponding = 0;

            Posts post = postCategory.getId().getPost();
            List<PostCategory> postCategoriesList = postCategoryRepo.findAllByIdPost(post);
            List<Categories> listCategories = new ArrayList<>();
            for (PostCategory i : postCategoriesList) {
                listCategories.add(i.getId().getCategory());
            }
            int size = listCategories.size();
            for (Categories categories1 : listCategories) {
                for (String categories2Name : categories) {
                    if (Objects.equals(categories1.getNameCategory(), categories2Name)) {
                        corresponding ++;
                    }
                }
            }
            if (nbCat == corresponding){
                if(!(postsWithAllCategories.contains(post))) {
                    postsWithAllCategories.add(post);
                }
            }
        }

        return postsWithAllCategories;
    }
}
