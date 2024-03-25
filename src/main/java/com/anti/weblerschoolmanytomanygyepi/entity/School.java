package com.anti.weblerschoolmanytomanygyepi.entity;

import com.anti.weblerschoolmanytomanygyepi.entity.base.Identifier;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class School extends Identifier {

    private String name;
    private String address;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
   // @JsonManagedReference
    private List<Course> courses;
}
