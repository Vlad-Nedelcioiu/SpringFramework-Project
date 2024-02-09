package com.example.Project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class ProjectConf {
    @Bean
    public Connection connection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projectdb","root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
