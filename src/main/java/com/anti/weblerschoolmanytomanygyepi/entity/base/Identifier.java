package com.anti.weblerschoolmanytomanygyepi.entity.base;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

@MappedSuperclass
@Getter
public class Identifier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = 10000L;
}
