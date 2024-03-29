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
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "Chat_Unique_Users_Pair", columnNames = {"user1", "user2"})
})
public class Chat {
    @Id
    @Column(name = "id_chat")
    private Long idChat;

    @ManyToOne
    @JoinColumn(name = "user1")
    private Users user1;

    @ManyToOne
    @JoinColumn(name = "user2")
    private Users user2;
}
