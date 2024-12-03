// ContactService.java
package com.Learning.lms.service;

import com.Learning.lms.model.Contact;
import com.Learning.lms.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        contact.setSubmittedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }
}