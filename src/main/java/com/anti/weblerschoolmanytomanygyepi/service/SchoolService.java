package com.anti.weblerschoolmanytomanygyepi.service;

import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.persistence.SchoolRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class SchoolService {

    private final SchoolRepository schoolRepository ;

    public List<School> findAllSchools() {
        return schoolRepository.findAll();
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public School  findSchoolByNameIgnoreCase(String name) {
        return schoolRepository.findSchoolByNameIgnoreCase(name);
    }

    public void deleteSchool(long id) {
         schoolRepository.deleteById(id);
    }

    public Optional<School> findSchoolById(long id)  {
        return schoolRepository.findById(id);
    }
    public School updateSchool(long id, School school) {
        School schoolExist = schoolRepository.findById(id).orElseThrow(() -> new NoSuchElementException("School not found with id: " + id));

        schoolExist.setAddress(school.getAddress());
        schoolExist.setName(school.getName());

        return  schoolRepository.save(schoolExist);
    }
}
