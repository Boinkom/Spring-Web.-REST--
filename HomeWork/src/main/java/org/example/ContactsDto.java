package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactsDto {

    // Имя и Фамилия, Телефонный номер, Email.
    @JsonProperty("name")
    private final String name;
    @JsonProperty("surname")
    private final String surname;
    @JsonProperty("phone")
    private final String phone;
    @JsonProperty("email")

    private final String email;

    public ContactsDto(Contacts contacts) {
        this.name = contacts.getName();
        this.surname = contacts.getSurname();
        this.phone = contacts.getPhone();
        this.email = contacts.getEmail();
    }
}
