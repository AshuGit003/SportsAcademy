package com.SportAcademy.Controller;

import com.SportAcademy.Model.CourseDetails;
import com.SportAcademy.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

//    @GetMapping
//    public List<CourseDetails> getAllCourses() {
//        return courseService.getAllCourses();
//    }

    @GetMapping("/{id}")
    public CourseDetails getCourseById(@PathVariable Long id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public CourseDetails createCourse(@RequestBody CourseDetails course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public CourseDetails updateCourse(@PathVariable Long id, @RequestBody CourseDetails course) {
        return courseService.updateCourse(id, course);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
