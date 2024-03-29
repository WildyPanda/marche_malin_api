package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Categories;
import com.epsi.marche_malin_api.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface MessageRepo extends JpaRepository<Message, Long> {
}
