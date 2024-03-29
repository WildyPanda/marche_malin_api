package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import org.springframework.data.repository.Repository;

public interface PostTagRepo extends Repository<Categories, String> {
}
