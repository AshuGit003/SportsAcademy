package com.SportAcademy.Service;

import com.SportAcademy.Model.CourseCards;
import com.SportAcademy.Repository.CoachRepository;
import com.SportAcademy.Repository.CourseCardRepository;
import com.SportAcademy.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class CourseCardServiceImpl implements CourseCardService {

    @Autowired
    private CourseCardRepository courseCardsRepo;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public List<CourseCards> getAllCourseCards() {
        return courseCardsRepo.findAll();
    }

    @Override
    public CourseCards getCourseCardsById(Long id) {
        return courseCardsRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CourseCard not found with id: " + id));
    }

    @Override
    public CourseCards createCourseCards(CourseCards courseCards) {
        return courseCardsRepo.save(courseCards);
    }

    @Override
    public CourseCards updateCourseCards(Long id, CourseCards courseCardsDetails) {
        CourseCards courseCards = getCourseCardsById(id);

        courseCards.setImageUrl(courseCardsDetails.getImageUrl());
        courseCards.setCourse(courseRepository.findById(courseCardsDetails.getCourse().getId())
                .orElseThrow(() -> new EntityNotFoundException("CourseCard not found with id: "+ courseCardsDetails.getCourse().getId())));
        courseCards.setCoach(coachRepository.findById(courseCardsDetails.getCoach().getId())
                .orElseThrow(() -> new EntityNotFoundException("CourseCard not found with id: "+ courseCardsDetails.getCoach().getId())));

        return courseCardsRepo.save(courseCards);
    }

    @Override
    public void deleteCourseCards(Long id) {
        CourseCards courseCards = getCourseCardsById(id);
        courseCardsRepo.delete(courseCards);
    }
}
