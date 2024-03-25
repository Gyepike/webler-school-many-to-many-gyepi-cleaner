package com.anti.weblerschoolmanytomanygyepi.entity;

import com.anti.weblerschoolmanytomanygyepi.entity.Course;
import com.anti.weblerschoolmanytomanygyepi.entity.base.Person;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Teacher extends Person {

    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    //@JsonManagedReference
    @JsonBackReference
    private List<Course> courses;
}
