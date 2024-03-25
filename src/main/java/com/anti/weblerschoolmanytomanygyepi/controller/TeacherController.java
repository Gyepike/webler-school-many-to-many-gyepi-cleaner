package com.anti.weblerschoolmanytomanygyepi.controller;

import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teachers")
    public ResponseEntity<List<Teacher>> renderAllUsers() {
        return ResponseEntity.status(200).body(teacherService.findAllTeacher());
    }

    @PostMapping("/teachers")
    public Teacher addNewEmployee(@RequestBody Teacher teacher) {return teacherService.saveTeacher(teacher);}

    @DeleteMapping("/teachers/{id}")
    public void deleteSchool(@PathVariable("id") long id) {teacherService.deleteTeacher(id);}

    @PutMapping("/teachers/{id}")
    public Teacher updateSchool(@PathVariable("id") long id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id,teacher);
    }
}
