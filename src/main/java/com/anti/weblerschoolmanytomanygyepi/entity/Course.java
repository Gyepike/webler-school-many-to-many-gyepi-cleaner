package com.anti.weblerschoolmanytomanygyepi.entity;

import com.anti.weblerschoolmanytomanygyepi.entity.base.Identifier;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Course extends Identifier {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    @ManyToMany
    @JoinTable(
            name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
                 //@JsonBackReference original
    private Teacher teacher;
}
