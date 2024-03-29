package com.epsi.marche_malin_api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    @Id
    @Column(name = "id_post")
    private int idPost;

    @Column(name = "title")
    private String title;

    @Column(name = "message")
    private String message;
}
