package com.epsi.marche_malin_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @Column(name = "uuid", nullable = false)
    private String uuid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = true)
    private String username;

    @Column(name = "phone_nb", nullable = true)
    private String phoneNb;
}
