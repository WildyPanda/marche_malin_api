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
public class PostTag {
    @EmbeddedId
    private PostTagId id;

    @Embeddable
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class PostTagId{
        @ManyToOne
        @JoinColumn(name = "post")
        private Posts post;

        @ManyToOne
        @JoinColumn(name = "tag")
        private Tags tag;
    }
}
