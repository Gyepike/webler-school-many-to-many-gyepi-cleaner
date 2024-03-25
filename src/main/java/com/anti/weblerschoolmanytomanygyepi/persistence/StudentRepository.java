package com.anti.weblerschoolmanytomanygyepi.persistence;

import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findStudentByEmailIgnoreCase(String email);
}
