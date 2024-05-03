package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
@Service
public class InMemoryContactsDao implements ContactsDao{
    private long contactsId = 1L;
    private final Map<Long, Contacts> contactsIdMap;

    public InMemoryContactsDao(Map<Long, Contacts> contactsIdMap) {
        this.contactsIdMap = contactsIdMap;
    }

    @Override
    public Contacts addContacts(String name, String surname, String phone, String email) {
        var contacts = new Contacts(contactsId,name,surname,phone,email);
        contactsIdMap.put(contactsId++, contacts);
        return contacts;
    }

    @Override
    public Optional<Contacts> findAccount(long contactsId) {
        return Optional.ofNullable(contactsIdMap.get(contactsId));
    }

    @Override
    public Contacts getAccount(long contactsId) throws IllegalAccessException {
        return findAccount(contactsId)
                .orElseThrow(() -> new IllegalAccessException("Contacts not found: " + contactsId));
    }

    @Override
    public List<Contacts> getAllContacts() {
        return new ArrayList<>(contactsIdMap.values());
    }

    @Override
    public Contacts updateContact(long contactsId, String newName, String newSurname, String newPhone, String newEmail) throws IllegalAccessException {
        Contacts existingContact = findAccount(contactsId)
                .orElseThrow(() -> new IllegalAccessException("Contacts not found: " + contactsId));

        existingContact.setName(newName);
        existingContact.setSurname(newSurname);
        existingContact.setPhone(newPhone);
        existingContact.setEmail(newEmail);

        return existingContact;
    }

}
