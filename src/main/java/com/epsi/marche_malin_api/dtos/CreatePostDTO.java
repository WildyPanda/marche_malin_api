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
public class CreatePostDTO {
    String title;
    Users user;
    List<byte[]> images;
    String message;
    List<String> tags;
    List<String> categories;
}
