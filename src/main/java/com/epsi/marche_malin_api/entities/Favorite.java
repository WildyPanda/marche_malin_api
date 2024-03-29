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
public class Favorite {
    @EmbeddedId
    private FavoriteId id;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class FavoriteId{
        @ManyToOne
        @JoinColumn(name = "user")
        private Users users;

        @ManyToOne
        @JoinColumn(name = "post")
        private Posts post;
    }
}
