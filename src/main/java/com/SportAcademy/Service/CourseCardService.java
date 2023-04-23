package com.SportAcademy.Service;

import com.SportAcademy.Model.CourseCards;

import java.util.List;

public interface CourseCardService {
    List<CourseCards> getAllCourseCards();

    CourseCards getCourseCardsById(Long id);

    CourseCards createCourseCards(CourseCards courseCards);

    CourseCards updateCourseCards(Long id, CourseCards courseCardsDetails);

    void deleteCourseCards(Long id);
}
