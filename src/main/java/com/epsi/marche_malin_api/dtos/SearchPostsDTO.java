package com.epsi.marche_malin_api.dtos;

import com.epsi.marche_malin_api.entities.Categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchPostsDTO {
    String title;
    List<String> tags;
    List<String> categories;
}
