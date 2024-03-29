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
public class Message {
    @Id
    @Column(name="id_message")
    private int idMessage;

    @Column(name = "message")
    private String message;

    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "chat")
    private Chat chat;
}
