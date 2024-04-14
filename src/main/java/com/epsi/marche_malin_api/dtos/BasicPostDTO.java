package com.epsi.marche_malin_api.dtos;

import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.entities.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BasicPostDTO {
    private Long idPost;
    private Users user;
    private String title;
    private String message;
    private Image image;

    public BasicPostDTO(Posts post, Optional<Image> image){
        this.idPost = post.getIdPost();
        this.user = post.getUser();
        this.title = post.getTitle();
        this.message = post.getMessage();
        this.image = image.orElse(null);
    }
}
