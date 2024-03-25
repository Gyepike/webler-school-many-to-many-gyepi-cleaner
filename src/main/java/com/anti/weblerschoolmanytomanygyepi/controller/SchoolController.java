package com.anti.weblerschoolmanytomanygyepi.controller;

import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @GetMapping("/schools")
    public ResponseEntity<List<School>> renderAllUsers() {
        return ResponseEntity.status(200).body(schoolService.findAllSchools());
    }

    @PostMapping("/schools")
    public School addNewEmployee(@RequestBody School school) {
        return schoolService.saveSchool(school);
    }


    @DeleteMapping("/schools/{id}")
    public void deleteSchool(@PathVariable("id") long id) {
        schoolService.deleteSchool(id);
    }

    @PutMapping("/schools/{id}")
    public School updateSchool(@PathVariable("id") long id, @RequestBody School school) {
        return schoolService.updateSchool(id,school);
    }
}
