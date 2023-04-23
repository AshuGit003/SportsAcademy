package com.SportAcademy.Service;

import com.SportAcademy.Model.CoachDetails;
import com.SportAcademy.Repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class CoachServiceImpl implements CoachService {

    @Autowired
    private CoachRepository coachRepository;

    @Override
    public List<CoachDetails> getAllCoaches() {
        return coachRepository.findAll();
    }

    @Override
    public CoachDetails getCoachById(Long id) {
        return (CoachDetails) coachRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coach not found with id: " + id));
    }

    @Override
    public CoachDetails createCoach(CoachDetails coach) {
        return coachRepository.save(coach);
    }

    @Override
    public CoachDetails updateCoach(Long id, CoachDetails course) {
        CoachDetails existingCoach = (CoachDetails) coachRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Coach not found with id: " + id));
        existingCoach.setFirstName(course.getFirstName());
        existingCoach.setLastName(course.getLastName());
        existingCoach.setEmail(course.getEmail());
        existingCoach.setPhoneNumber(course.getPhoneNumber());
        existingCoach.setDescription(course.getDescription());
        return coachRepository.save(existingCoach);
    }

    @Override
    public void deleteCoach(Long id) {
        coachRepository.deleteById(id);
    }
}
