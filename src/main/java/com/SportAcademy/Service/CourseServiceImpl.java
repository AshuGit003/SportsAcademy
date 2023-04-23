package com.SportAcademy.Service;

import com.SportAcademy.Model.CourseDetails;
import com.SportAcademy.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDetails> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public CourseDetails getCourseById(Long id) {
        return (CourseDetails) courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));
    }

    @Override
    public CourseDetails createCourse(CourseDetails course) {
        return courseRepository.save(course);
    }

    @Override
    public CourseDetails updateCourse(Long id, CourseDetails course) {
        CourseDetails existingCourse = (CourseDetails) courseRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course not found with id: " + id));
        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setCourseDescription(course.getCourseDescription());
        return courseRepository.save(existingCourse);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
