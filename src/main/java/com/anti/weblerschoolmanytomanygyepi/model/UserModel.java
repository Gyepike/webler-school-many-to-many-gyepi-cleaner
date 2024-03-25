package com.anti.weblerschoolmanytomanygyepi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {

    private Long id;
    private String email;
    private String username;
}
