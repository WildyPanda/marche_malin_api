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
public class PostCategory {
    @EmbeddedId
    private PostCategoryId id;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    static public class PostCategoryId{
        @ManyToOne
        @JoinColumn(name = "post")
        private Posts post;

        @ManyToOne
        @JoinColumn(name = "category")
        private Categories category;
    }
}
