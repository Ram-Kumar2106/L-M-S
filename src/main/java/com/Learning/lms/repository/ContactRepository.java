// ContactRepository.java
package com.Learning.lms.repository;

import com.Learning.lms.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}