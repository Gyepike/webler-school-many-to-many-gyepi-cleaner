package com.anti.weblerschoolmanytomanygyepi.service;


import com.anti.weblerschoolmanytomanygyepi.entity.School;
import com.anti.weblerschoolmanytomanygyepi.entity.Student;
import com.anti.weblerschoolmanytomanygyepi.entity.Teacher;
import com.anti.weblerschoolmanytomanygyepi.persistence.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> findAllStudent() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Student updateStudent(long id, Student student) {

        Student  studentExist = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("School not found with id: " + id));

        System.out.println(student.isPaid());

        studentExist.setPaid(student.isPaid());
        studentExist.setFirstName(student.getFirstName());
        studentExist.setCell(student.getCell());
        studentExist.setEmail(student.getEmail());
        studentExist.setFirstName(student.getFirstName());
        studentExist.setLastName(student.getLastName());
        studentExist.setDateOfBirth(student.getDateOfBirth());
        studentExist.setMidName(student.getMidName());
        studentExist.setStatus(student.getStatus());

        return  studentRepository.save(studentExist);
    }

    public Optional<Student> findStudentById(long id)  {
        return studentRepository.findById(id);
    }
}
