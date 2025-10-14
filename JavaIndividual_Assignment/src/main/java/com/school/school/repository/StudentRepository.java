package com.school.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.school.school.beans.Student;

public interface StudentRepository extends JpaRepository <Student,Long> {
	  Optional<Student> findByEmail(String email);
	  Optional <Student> findById(int id);

}
