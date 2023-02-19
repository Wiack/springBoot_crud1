package com.example.springBoot_crud1.service;

import com.example.springBoot_crud1.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void update(User user);

    void delete(Long id);
}
