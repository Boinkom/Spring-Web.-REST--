package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ContactsDao {

    Contacts addContacts(String name,String surname,String phone,String email);

     Optional<Contacts> findAccount(long contactsId);
     Contacts getAccount(long accountId) throws IllegalAccessException;

    List<Contacts> getAllContacts();

    Contacts updateContact(long contactsId, String newName, String newSurname, String newPhone, String newEmail) throws IllegalAccessException;

}
