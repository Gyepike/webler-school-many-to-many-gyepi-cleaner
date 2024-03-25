package com.anti.weblerschoolmanytomanygyepi.service;

import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.persistence.TeacherRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> findAllTeacher() {
        return teacherRepository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }


    public Teacher  findTeacherByNameIgnoreCase(String name) {
        return teacherRepository.findTeacherByNameIgnoreCase(name);
    }

    public Optional<Teacher> findTeacherById(long id)  {
        return teacherRepository.findById(id);
    }
    public void deleteTeacher(long id) {
        teacherRepository.deleteById(id);
    }

    public Teacher updateTeacher(long id, Teacher teacher) {

        Teacher  teacherExist = teacherRepository.findById(id).orElseThrow(() -> new NoSuchElementException("School not found with id: " + id));

        teacherExist.setName(teacher.getName());
        teacherExist.setFirstName(teacher.getFirstName());
        teacherExist.setCell(teacher.getCell());
        teacherExist.setEmail(teacher.getEmail());
        teacherExist.setFirstName(teacher.getFirstName());
        teacherExist.setLastName(teacher.getLastName());
        teacherExist.setDateOfBirth(teacher.getDateOfBirth());
        teacherExist.setMidName(teacher.getMidName());

        return  teacherRepository.save(teacherExist);
    }
}
