package com.anti.weblerschoolmanytomanygyepi.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "webler_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NonNull
    @Column(unique = true)
    private  String email;

    @NonNull
    private String username;

    @NonNull
    private String password;
}
