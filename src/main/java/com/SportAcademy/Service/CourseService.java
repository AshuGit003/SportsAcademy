package com.SportAcademy.Service;

import com.SportAcademy.Model.CourseDetails;

import java.util.List;

public interface CourseService {
    List<CourseDetails> getAllCourses();

    CourseDetails getCourseById(Long id);

    CourseDetails createCourse(CourseDetails course);

    CourseDetails updateCourse(Long id, CourseDetails course);

    void deleteCourse(Long id);
}
