package com.anti.weblerschoolmanytomanygyepi.controller;

import com.anti.weblerschoolmanytomanygyepi.entity.Course;
import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.entity.Student;
import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.service.CourseService;
import com.anti.weblerschoolmanytomanygyepi.service.SchoolService;
import com.anti.weblerschoolmanytomanygyepi.service.StudentService;
import com.anti.weblerschoolmanytomanygyepi.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CourseController {

    private final CourseService courseService;
    private final SchoolService schoolService;
    private  final TeacherService teacherService;
    private  final StudentService studentService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> renderAllUsers() {
        return ResponseEntity.status(200).body(courseService.findAllCourses());
    }

    @PostMapping("/courses")
    public Course addNewCoursewithoutDetails(@RequestBody Course course) {
        return courseService.saveCourseSimple(course);
    }

    @PostMapping("/courses/schools/{schoolId}/teachers/{teacherId}/students/{studentId}")
    public Course addNewCourse(
            @PathVariable("schoolId") long schoolId,
            @PathVariable("teacherId") long teacherId,
            @PathVariable("studentId") long studentId,

            @RequestBody Course courseInsert
            ) {
        System.out.println(schoolId);
        System.out.println(teacherId);
        System.out.println(studentId);
        System.out.println(courseInsert);

        Optional<Teacher> teacher =  teacherService.findTeacherById(teacherId);
        Optional<School> school = schoolService.findSchoolById(schoolId);
        Optional<Student>  student = studentService.findStudentById(studentId);
        List<Student> students = new ArrayList<>();
        Course course= new Course();

        if(teacher.isPresent() && student.isPresent() && student.isPresent()) {
            System.out.println(teacher);
            System.out.println(school);
            System.out.println(student);

            students.add(student.get());
            course.setSchool(school.get());
            course.setTeacher(teacher.get());
            course.setStudents(students);
            course.setName(courseInsert.getName());
            course.setDescription(courseInsert.getDescription());

            System.out.println(course);
            return  courseService.saveCourseSimple(course);
        }

        return null;
    }


    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable("id") long id) {
        courseService.deleteCourse(id);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable("id") long id, @RequestBody Course course) {
        return courseService.updateSchool(id, course);
    }
}

// public Course addNewCourse;
//https://www.bezkoder.com/jpa-one-to-many/