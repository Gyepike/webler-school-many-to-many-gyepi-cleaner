package com.anti.weblerschoolmanytomanygyepi.entity;

import com.anti.weblerschoolmanytomanygyepi.entity.base.Person;
import com.anti.weblerschoolmanytomanygyepi.value.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student extends Person {

    @CreationTimestamp
    private LocalDateTime registrationDate = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.INACTIVE;

    private boolean isPaid = false;

    @ManyToMany(mappedBy = "students")
    private List<Course> courses;
}
