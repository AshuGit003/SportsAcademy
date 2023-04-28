package com.SportAcademy.Service;

import com.SportAcademy.Model.ApplicationForm;

import java.util.List;

public interface ApplicationFormService {
    List<ApplicationForm> getAllApplicationForm();

    ApplicationForm getApplicationFormById(Long id);

    ApplicationForm createApplicationForm(ApplicationForm applicationForm);

    void deleteApplicationForm(Long id);
}
