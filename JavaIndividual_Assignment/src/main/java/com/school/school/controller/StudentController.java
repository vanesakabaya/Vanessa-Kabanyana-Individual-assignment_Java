package com.school.school.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.school.school.beans.Student;
import com.school.school.service.StudentService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Create student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Get all students
    @GetMapping("/allstudent")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get one student
    @GetMapping("/individualStudent/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id).orElse(null);
    }

    // Update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Delete student
    @DeleteMapping("/deleteStudentById/{id}")
    public String deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        return deleted ? "Student deleted successfully!" : "Student not found!";
    }
}
