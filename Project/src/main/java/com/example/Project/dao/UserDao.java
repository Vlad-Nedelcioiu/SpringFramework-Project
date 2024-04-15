package com.example.Project.dao;

import com.example.Project.model.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    private Connection connection;

    PreparedStatement createUser;
    PreparedStatement verifyUser;
    PreparedStatement checkIfUserNameExists;


    public UserDao(Connection connection) {
        this.connection = connection;

        try {
            createUser = connection.prepareStatement("INSERT INTO users VALUES(null, ?, ?)");
            verifyUser = connection.prepareStatement("SELECT name, password FROM users WHERE name = ? AND password = ?");
            checkIfUserNameExists = connection.prepareStatement("SELECT name FROM users WHERE name = ?");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createUser(String name, String password){
        try {
            createUser.setString(1,name);
            createUser.setString(2,password);
            createUser.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean verifyUser(String name, String password){
        try {
            verifyUser.setString(1, name);
            verifyUser.setString(2,password);
            ResultSet resultSet = verifyUser.executeQuery();

            if(resultSet.next()){
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkIfUserNameExists(String name){
        try {
            checkIfUserNameExists.setString(1,name);
            ResultSet resultSet = checkIfUserNameExists.executeQuery();
            while(resultSet.next()){
                if(resultSet.getString("name").equals(name)){
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
