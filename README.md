GET /contacts для получения всех контактов: curl -X GET http://localhost:8080/contact/all

GET /contact/{contactId} для получения конкретного контакта: curl http://localhost:8080/contact/1

POST /contacts для добавления контакта (при создании контакту присваивается идентификатор): curl -X POST -d "name=John&surname=Doe&phone=123456783&email=john@example.com" http://localhost:8080/contact

PUT /contacts/{contactId} для изменения уже существующей контактной информации: curl -X PUT -d "name=NewName" -d "surname=NewSurname" -d "phone=NewPhone" -d "email=newemail@example.com" http://localhost:8080/contact/1
