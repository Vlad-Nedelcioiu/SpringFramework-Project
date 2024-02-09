package com.example.Project.service;

import com.example.Project.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createUser(String name, String password){
        if(!userDao.checkIfUserNameExists(name)) {
            userDao.createUser(name, password);
        } else System.out.println("Acest username exista deja");
    }

    public boolean verifyUser(String name, String password){
        return userDao.verifyUser(name,password);
    }

}
