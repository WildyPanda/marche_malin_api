package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.PostCategory;
import com.epsi.marche_malin_api.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface ImageRepo extends JpaRepository<Image, Long> {
    public List<Image> findAllByPost(Posts post);
    public Optional<Image> findFirstByPost(Posts posts);
}
