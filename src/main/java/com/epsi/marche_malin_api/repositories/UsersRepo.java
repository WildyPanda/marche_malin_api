package com.epsi.marche_malin_api.repositories;

import com.epsi.marche_malin_api.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface UsersRepo extends JpaRepository<Users, String> {
    public Optional<Users> findByEmail(String email);
    public Optional<Users> findByUsername(String username);
}
