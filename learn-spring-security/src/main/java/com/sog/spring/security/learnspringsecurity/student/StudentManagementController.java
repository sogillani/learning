package com.sog.spring.security.learnspringsecurity.student;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("management/api/v1/students")
public class StudentManagementController {

    Logger logger = LoggerFactory.getLogger(StudentManagementController.class);

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Anna"),
            new Student(2, "John"),
            new Student(3, "Maria")
    );

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getStudents() {
        return STUDENTS;
    }

    @GetMapping(path = "{studentId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        Optional<Student> studentOptional = STUDENTS.stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst();

        if (studentOptional.isPresent())
            return studentOptional.get();

        return null;
    }

    @PostMapping
    @PreAuthorize(("hasAuthority('student:write')"))
    public void registerNewStudent(@RequestBody Student student) {
        logger.info("Student: {}", student);
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize(("hasAuthority('student:write')"))
    public void deleteStudent(@PathVariable("studentId") Integer studentId) {
        logger.info("Student Id: {}", studentId);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize(("hasAuthority('student:write')"))
    public void updateStudent(@PathVariable("studentId") Integer studentId, @RequestBody Student student) {
        logger.info("Student Id: {}, Student: {}", studentId, student);
    }
}
