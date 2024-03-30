package com.epsi.marche_malin_api.dtos;

import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.Posts;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddImageDTO {
    private Long id_image;
    private Long id_post;
    private byte[] image;
}
