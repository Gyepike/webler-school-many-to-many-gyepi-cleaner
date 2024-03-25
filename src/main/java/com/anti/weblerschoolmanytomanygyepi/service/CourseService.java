package com.anti.weblerschoolmanytomanygyepi.service;

import com.anti.weblerschoolmanytomanygyepi.entity.Course;
import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.persistence.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;

    private final SchoolService schoolService;

    private final TeacherService teacherService;

    public List<Course> findAllCourses() {
        return courseRepository.findAll() ;
    }

    public Course saveCourse(Course course) {
        School existingSchool =  schoolService.findSchoolByNameIgnoreCase(course.getName());
        Teacher existingTeacher = teacherService.findTeacherByNameIgnoreCase(course.getName());

        if (existingSchool != null) {
            course.setSchool(existingSchool);
        } else {
            School school = new School();

            school.setName(course.getSchool().getName());
            school.setAddress(course.getSchool().getAddress());

            existingSchool = schoolService.saveSchool(school);
            course.setSchool(existingSchool);
        }

        if (existingTeacher != null) {
            course.setTeacher(existingTeacher);
        } else {
            Teacher teacher = new Teacher();

            teacher.setName(course.getTeacher().getName());
            teacher.setMidName(course.getTeacher().getMidName());
            teacher.setLastName(course.getTeacher().getLastName());
           // teacher.setDateOfBirth(course.getTeacher().getDateOfBirth());
            teacher.setEmail(course.getTeacher().getEmail());
            teacher.setCell(course.getTeacher().getCell());

            existingTeacher = teacherService.saveTeacher(teacher);
            course.setTeacher(existingTeacher);
        }

        return courseRepository.save(course);
    }

    public Course saveCourseSimple(Course course) {

        return courseRepository.save(course);
    }
    public void deleteCourse(long id) {
        courseRepository.deleteById(id);
    }

    public Course updateSchool(long id, Course course) {

        Course existingCourse = courseRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Course not found with id: " + id));

        existingCourse.setSchool(course.getSchool());
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setTeacher(course.getTeacher());

        return courseRepository.save(existingCourse);
    }
}
