package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactsController {
    private final ContactsFacade contactsFacade;

    @Autowired
    public ContactsController(ContactsFacade contactsFacade) {
        this.contactsFacade = contactsFacade;
    }

    @PostMapping
    public ContactsDto createContacts(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "email") String email) {
        return contactsFacade.createAccount(name, surname, phone, email);
    }

    @GetMapping("/{findcontacts}")
    public ContactsDto getContacts(
            @PathVariable(name = "findcontacts") long contactsId) throws IllegalAccessException {
        return contactsFacade.getContacts(contactsId);
    }

    @GetMapping("/all")
    public List<ContactsDto> getAllContacts() {
        return contactsFacade.getAllContacts();
    }

    @PutMapping("/{contactsId}")
    public ContactsDto updateContact(
            @PathVariable(name = "contactsId") long contactsId,
            @RequestParam(name = "name") String name,
            @RequestParam(name = "surname") String surname,
            @RequestParam(name = "phone") String phone,
            @RequestParam(name = "email") String email) throws IllegalAccessException {
        return contactsFacade.updateContact(contactsId, name, surname, phone, email);
    }

}
