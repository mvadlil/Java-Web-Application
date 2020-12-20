/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.g2academy.bootcamp.service;

import co.g2academy.bootcamp.dao.PersonDaoJDBC;
import co.g2academy.bootcamp.entity.Person;
import co.g2academy.bootcamp.model.Authenticator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static jdk.internal.util.StaticProperty.userName;

/**
 *
 * @author fadli
 */
public class PersonService {
    
    // 1. load my sql JDBC Driver
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    // 2. create database connection
    private static Connection connection;
    public static Connection getConnection(){
        if(connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_bootcamp",
                    "mvadlil","nakamasenpai"); 
            } catch (SQLException e) {
                Logger.getLogger(Authenticator.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return connection;
    }
    
    private PersonDaoJDBC personDao;
    public PersonService() {
        try {
            this.personDao = new PersonDaoJDBC();
            personDao.setConnection(getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Person save(Person p) {
        try {
            getConnection().setAutoCommit(false);
            personDao.save(p);
            getConnection().commit();
            getConnection().setAutoCommit(true);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public Person delete(Person p) {
        try {
            getConnection().setAutoCommit(false);
            personDao.delete(p);
            getConnection().commit();
            getConnection().setAutoCommit(true);
            return p;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                getConnection().rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public Person getPersonByUserName(String userName) {
        try {
            return personDao.getByUserName(userName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Person getPersonById(Integer id) {
        try {
            return personDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Person> getPersons() {
        try {
            return personDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Collections.emptyList(); 
    }
}
