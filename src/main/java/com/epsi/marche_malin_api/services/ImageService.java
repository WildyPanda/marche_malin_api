package com.epsi.marche_malin_api.services;

import com.epsi.marche_malin_api.dtos.AddImageDTO;
import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.repositories.ImageRepo;
import com.epsi.marche_malin_api.repositories.PostsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    PostsRepo postsRepo;
    @Autowired
    ImageRepo imageRepo;

    public void AddImage(AddImageDTO dto){
        Optional<Posts> optPost = postsRepo.findById(dto.getId_post());
        if(optPost.isPresent()){
            Posts posts = optPost.get();
            imageRepo.save(new Image(dto.getId_image(), dto.getImage(), posts));
        }
    }

    public void DeleteAllByPost(Posts post){
        List<Image> images = imageRepo.findAllByPost(post);
        for(Image image : images){
            imageRepo.delete(image);
        }
    }

    public Optional<Image> GetFirstOfPost(Posts post){
        return imageRepo.findFirstByPost(post);
    }
}
