package com.school.school.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.school.beans.Student;
import com.school.school.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService  {

    @Autowired
    private StudentRepository studentRepository;

    // Create or Save student
    public Student saveStudent(@org.jetbrains.annotations.NotNull Student student) {
    	
    	
    	if (studentRepository.findByEmail(student.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email student already exists: " + student.getEmail());
    	}
    	
        return studentRepository.save(student);
    }

    // Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Get student by ID
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update student
    public Student updateStudent(Long id, Student updatedStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setFirst_Name(updatedStudent.getFirstName());
                    student.setLast_Name(updatedStudent.getLastName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setPhone_number(updatedStudent.getPhone_number());
                    return studentRepository.save(student);
                })
                .orElse(null);
    }

    // Delete student
    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
