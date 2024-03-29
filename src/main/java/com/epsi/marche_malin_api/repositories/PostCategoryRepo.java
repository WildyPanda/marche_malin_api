package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.PostCategory;
import com.epsi.marche_malin_api.entities.PostCategory.PostCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PostCategoryRepo extends JpaRepository<PostCategory, PostCategoryId> {
}
