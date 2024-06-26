package com.epsi.marche_malin_api.dtos;

import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetPostDTO {
    private Long id_post;
    private String title;
    private Users user;
    private List<Image> images;
    private String message;
    private List<String> tags;
    private List<String> categories;
}
