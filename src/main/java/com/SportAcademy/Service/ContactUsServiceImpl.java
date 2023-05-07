package com.SportAcademy.Service;

import com.SportAcademy.Model.ContactUs;
import com.SportAcademy.Repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ContactUsServiceImpl implements ContactUsService{

    @Autowired
    private ContactUsRepository contactUsRepository;

    @Override
    public ContactUs createContactUs(ContactUs contact) {
        return contactUsRepository.save(contact);
    }
}
