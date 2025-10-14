package com.school.school.service;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.school.beans.Course;
import com.school.school.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // Create
    public Course createCourse(Course course) 
    { // ✅ Check for duplicate title
        if (courseRepository.findByTitle(course.getTitle()).isPresent()) {
            throw new RuntimeException("Course title already exists: " + course.getTitle());
        }
        return courseRepository.save(course);
    
    }

    // Read all
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // Read by ID
    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    // Update
    public Course updateCourse(Long id, Course updatedCourse) {
        return courseRepository.findById(id).map(course -> {
            course.setTitle(updatedCourse.getTitle());
            course.setCredits(updatedCourse.getCredits());
            return courseRepository.save(course);
        }).orElseThrow(() -> new RuntimeException("Course not found with id " + id));
    }

    // Delete
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
