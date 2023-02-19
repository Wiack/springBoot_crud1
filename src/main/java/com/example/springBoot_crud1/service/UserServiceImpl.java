package com.example.springBoot_crud1.service;

import com.example.springBoot_crud1.dao.UserDAO;
import com.example.springBoot_crud1.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }


    @Override
    public List<User> getUsers() {

        return userDao.getUsers();
    }

    @Override
    public User getUserById(Long id) {

        return userDao.getUserById(id);
    }

    @Override
    @Transactional
    public void saveUser(User user) {

        userDao.saveUser(user);
    }


    @Override
    @Transactional
    public void update(User user) {

        userDao.update(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {

        userDao.delete(id);
    }
}