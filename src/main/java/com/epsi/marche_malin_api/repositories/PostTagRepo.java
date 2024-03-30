package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.PostCategory;
import com.epsi.marche_malin_api.entities.PostTag;
import com.epsi.marche_malin_api.entities.PostTag.PostTagId;
import com.epsi.marche_malin_api.entities.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;

public interface PostTagRepo extends JpaRepository<PostTag, PostTagId> {
    public List<PostTag> findAllByIdPost(Posts post);
}
