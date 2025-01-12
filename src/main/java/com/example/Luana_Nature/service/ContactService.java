package com.example.Luana_Nature.service;


import com.example.Luana_Nature.model.Contact;
import com.example.Luana_Nature.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;


    public List<Contact> getAllContactMessages() {
        return contactRepository.findAll();
    }

    public void addContactmessage(String name, String message) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setMessage(message);
        contactRepository.save(contact);
    }
}
