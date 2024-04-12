package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TagsRepo extends JpaRepository<Tags, String> {

    @Query("SELECT t FROM Tags t WHERE t.nameTag LIKE %:keyword%")
    List<Tags> findByNomTag(@Param("keyword") String keyword);
}
