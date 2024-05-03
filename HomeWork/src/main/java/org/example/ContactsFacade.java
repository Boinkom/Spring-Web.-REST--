package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactsFacade {
    private final ContactsDao contactsDao;
    @Autowired
    public ContactsFacade(ContactsDao contactsDao) {
        this.contactsDao = contactsDao;
    }
    public ContactsDto createAccount(String name, String surname, String phone,String email){
    var contacts = contactsDao.addContacts(name,surname,phone,email);
    return  new ContactsDto(contacts);
    }
    public ContactsDto getContacts(long contactsId) throws IllegalAccessException {
    var contacts = contactsDao.getAccount(contactsId);
    return new ContactsDto(contacts);
    }

    public List<ContactsDto> getAllContacts() {
        List<Contacts> contactsList = contactsDao.getAllContacts();
        List<ContactsDto> contactsDtoList = new ArrayList<>();
        for (Contacts contacts : contactsList) {
            contactsDtoList.add(new ContactsDto(contacts));
        }
        return contactsDtoList;
    }

    public ContactsDto updateContact(long contactsId, String newName, String newSurname, String newPhone, String newEmail) throws IllegalAccessException {
        var updatedContact = contactsDao.updateContact(contactsId, newName, newSurname, newPhone, newEmail);
        return new ContactsDto(updatedContact);
    }
}
