package com.epsi.marche_malin_api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @Column(name = "uuid", nullable = false)
    @Setter(AccessLevel.NONE)
    private String uuid;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = true, unique = true)
    private String username;

    @Column(name = "phone_nb", nullable = true)
    private String phoneNb;
}
