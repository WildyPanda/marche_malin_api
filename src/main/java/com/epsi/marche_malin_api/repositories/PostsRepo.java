package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.Image;
import com.epsi.marche_malin_api.entities.Posts;
import com.epsi.marche_malin_api.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface PostsRepo extends JpaRepository<Posts, Long> {
    public List<Posts> findByTitleContaining(String title);
    public List<Posts> findByUser(Users user);
}
