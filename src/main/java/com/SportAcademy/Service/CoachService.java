package com.SportAcademy.Service;

import com.SportAcademy.Model.CoachDetails;

import java.util.List;

public interface CoachService {
    List<CoachDetails> getAllCoaches();

    CoachDetails getCoachById(Long id);

    CoachDetails createCoach(CoachDetails coach);

    CoachDetails updateCoach(Long id, CoachDetails course);

    void deleteCoach(Long id);
}
