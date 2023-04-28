package com.SportAcademy.Service;

import com.SportAcademy.Model.ApplicationForm;
import com.SportAcademy.Repository.ApplicationFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Transactional
public class ApplicationFormServiceImpl implements ApplicationFormService{

    @Autowired
    private ApplicationFormRepository applicationFormRepository;

    @Override
    public List<ApplicationForm> getAllApplicationForm() {
        return applicationFormRepository.findAll();
    }


    @Override
    public ApplicationForm getApplicationFormById(Long id) {
        return applicationFormRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CourseCard not found with id: " + id));
    }

    @Override
    public ApplicationForm createApplicationForm(ApplicationForm applicationForm) {
        return applicationFormRepository.save(applicationForm);
    }

    @Override
    public void deleteApplicationForm(Long id) {
        ApplicationForm applicationForm = getApplicationFormById(id);
        applicationFormRepository.delete(applicationForm);
    }

}
