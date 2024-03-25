package com.anti.weblerschoolmanytomanygyepi.persistence;

import com.anti.weblerschoolmanytomanygyepi.entity.Course;
import com.anti.weblerschoolmanytomanygyepi.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
   Course findCourseByNameIgnoreCase(String name);
}
