package com.crud.crudinvestimentos.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_users")
@Data
public class User {

    public User(String username, String email, String password, Instant creationalTimeStamp, Instant updatedTimeStamp) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.creationalTimeStamp = creationalTimeStamp;
        this.updatedTimeStamp = updatedTimeStamp;
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID idUser;

    @Column(name = "username")
    private String username;

    @Column(name  = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @CreationTimestamp
    private Instant creationalTimeStamp;

    @UpdateTimestamp
    private Instant updatedTimeStamp;
}
