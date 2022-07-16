package ru.ageevvo.crud_spring_boot.service;

import ru.ageevvo.crud_spring_boot.models.User;

import java.util.List;

public interface UserService {
    User findById(Long id);

    List<User> findAll();

    void saveUser(User user);

    void deleteUser(Long id);
}
