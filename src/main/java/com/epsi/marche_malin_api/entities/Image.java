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
public class Image {
    @Id
    @Column(name = "id_image")
    private int idImage;

    @Lob
    @Column(name = "image", columnDefinition = "BLOB")
    private byte[] image;

    @ManyToOne
    @JoinColumn(name = "id_post")
    private Posts post;
}
