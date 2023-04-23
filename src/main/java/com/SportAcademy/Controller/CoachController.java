package com.SportAcademy.Controller;

import com.SportAcademy.Model.CoachDetails;
import com.SportAcademy.Service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user/coach")
public class CoachController {
    @Autowired
    private CoachService coachService;

    @GetMapping("/{id}")
    public CoachDetails getCoachById(@PathVariable Long id) {
        return coachService.getCoachById(id);
    }

    @PostMapping
    public CoachDetails createCoach(@RequestBody CoachDetails coach) {
        return coachService.createCoach(coach);
    }

    @PutMapping("/{id}")
    public CoachDetails updateCoach(@PathVariable Long id, @RequestBody CoachDetails coach) {
        return coachService.updateCoach(id, coach);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoach(@PathVariable Long id) {
        coachService.deleteCoach(id);
        return ResponseEntity.noContent().build();
    }
}
