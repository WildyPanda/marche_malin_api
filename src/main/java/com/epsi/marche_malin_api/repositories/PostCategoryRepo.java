package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.PostCategory;
import com.epsi.marche_malin_api.entities.PostCategory.PostCategoryId;
import com.epsi.marche_malin_api.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PostCategoryRepo extends JpaRepository<PostCategory, PostCategoryId> {
    public List<PostCategory> findAllByIdPost(Posts post);
}
