package com.booking.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.booking.model.Contact;
import com.booking.repositories.ContactRepo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // the logs by here
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor // we gonna be doing a dependency injection here
public class ContactService {
    private final ContactRepo contactRepo;
    public Page<Contact> getAllContact(int page, int size) {
        return contactRepo.findAll(PageRequest.of(page, size, Sort.by("name")));
    };
    public Contact getContactById(String id) {
        return contactRepo.findById(id).orElseThrow(() -> new RuntimeException("Contact not found"));
    };
    public Contact createContact(Contact contact) {
        return contactRepo.save(contact);
    };
    public void deleteContact(Contact contact) {

//     };
//     public String uploadPhoto(String id, MultipartFile file) {
//         Contact contact = getContactById(id);
//         String photoUrl = null;
//         contact.setPhotoUrl(photoUrl);
//     }
}
