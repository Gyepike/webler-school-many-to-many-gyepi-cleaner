package com.anti.weblerschoolmanytomanygyepi.controller;


import com.anti.weblerschoolmanytomanygyepi.entity.Student;
import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> renderAllUsers() {
        return ResponseEntity.status(200).body(studentService.findAllStudent());
    }

    @PostMapping("/student")
    public Student addNewStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable("id") long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/student/{id}")
    public Student updateSchool(@PathVariable("id") long id, @RequestBody Student student) {
        return studentService.updateStudent(id,student);
    }
}
